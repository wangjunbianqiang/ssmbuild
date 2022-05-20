package com.wj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                 //创建get和set方法和ToString
@AllArgsConstructor  //有参构造的注解
@NoArgsConstructor   //无参构造的注解
public class Books {
    private int bookID;
    private String bookName;
    private int bookCounts;
    private String detail;
}
