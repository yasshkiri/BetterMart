package com.PIDEV.demo.services;



import com.PIDEV.demo.entities.Comment;
import com.PIDEV.demo.entities.Customer;
import com.PIDEV.demo.entities.Publication;
import com.PIDEV.demo.repository.CommentRepository;
import com.PIDEV.demo.repository.CustomerRepository;
import com.PIDEV.demo.repository.PublicationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CommentService implements ICommentService {


    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PublicationRepository publicationRepository;
    @Autowired
    CustomerRepository customerRepository;

    //ajouter
    @Override
    public Comment addCom(Comment comment) {


        commentRepository.save(comment);

        return comment;

    }

    //affichage
    @Override
    public List<Comment> fetchCommentList()
    {
        return  commentRepository.findAll();
    }

    @Override
    public Comment getCommentById(Integer id){
        return commentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
    }

    //modifier
    public Comment updateCom(Comment comment) {

        commentRepository.save(comment);

        return comment;
    }

    public Optional<Comment> getComById(Integer id) {

        return commentRepository.findById(id);

    }


    //supprimer
    public void deleteCom() {

        commentRepository.deleteAll();
    }

    @Override
    public void deleteComById(Integer id) {

        commentRepository.deleteById(id);
    }

    /*//ajouter&affecter
    @Transactional
    @Override
    public Comment addAndassignComToPub(Comment comment, Integer idPub) {
        commentRepository.save(comment);
        Publication publication = publicationRepository.findById(idPub).orElse(null);
        comment.setPublication(publication);
        commentRepository.save(comment);
        return comment;
    }*/

    //ajouter&2affecter
    @Transactional
    @Override
    public Comment AddandAssignComtoPubtoUser(Comment comment, Integer idPub, Integer id) {
        Customer customer = customerRepository.findById(id).orElse(null);
        System.err.println(customer.getId());
        comment.setCustomer(customer);

        Publication publication = publicationRepository.findById(idPub).orElse(null);
        comment.setPublication(publication);
        comment.setDateCom(LocalDateTime.now());

        List<String> badWords = fetchBadWords();
        boolean containsBadWord = false;
        for (String badWord : badWords) {
            if (comment.getCom().toLowerCase().contains(badWord.toLowerCase())) {
                containsBadWord = true;
                break;
            }
        }
        if (containsBadWord) {

                    log.info("This comment contains inappropriate language ");
            return null;
        }

        commentRepository.save(comment);
        return comment;
    }

    //bad words
    private List<String> fetchBadWords() {
        List<String> badWords = new ArrayList<>();
        try {
            URL url = new URL("https://docs.google.com/spreadsheets/d/1hIEi2YG3ydav1E06Bzf2mQbGZ12kh2fe4ISgLg_UBuM/export?format=csv");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length > 0) {
                    badWords.add(values[0]);
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return badWords;
    }


    @Override
    public List<Comment> triCom() {
        return commentRepository.triCom();
    }



}
