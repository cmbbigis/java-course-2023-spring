package edu.java.client.response;

import java.time.OffsetDateTime;
import lombok.Data;

@Data
public class StackOverflowQuestionResponse {
    private String title;

    private String link;

    private OffsetDateTime creationDate;
}
