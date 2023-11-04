package com.PIDEV.demo.SMS;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;


@Component
public class SmsService {


    private final String ACCOUNT_SID ="AC74f6ca913c873955a421df73ce4efe20";

    private final String AUTH_TOKEN = "833d1953229f6413f64af4845205c28d";

    private final String FROM_NUMBER = "+15673131571";

    public void send(SmsPojo sms) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER), sms.getMessage())
                .create();
        System.out.println("here is my id:"+message.getSid());// Unique resource ID created to manage this transaction

    }

    public void receive(MultiValueMap<String, String> smscallback) {
    }

}
