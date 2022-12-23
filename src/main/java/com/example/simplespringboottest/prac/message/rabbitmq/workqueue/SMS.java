package com.example.simplespringboottest.prac.message.rabbitmq.workqueue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SMS {
    private String name;
    private String mobile;
    private String content;

}
