package com.example.demo_student.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Khoa {
    private long Id;
    private String khoaName;
    private String khoaAddress;
    private String khoaCode;
}

