package com.eric.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author EricRaww
 * @create 2020-11-21
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Payment implements Serializable {
    private Long id;
    private String serial;
}
