package com.servPet.psCompl.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 實體類別對應資料表 PET_SITTER_COMPLAINT
 * 
 * 註1: classpath必須有javax.persistence-api-x.x.jar
 * 註2: Annotation 可以添加在屬性上，也可以添加在 getXxx() 方法上
 */

@Entity  // 表示該類別是一個 JPA 實體
@Table(name = "PET_SITTER_COMPLAINT")  // 對應資料表 PET_SITTER_COMPLAINT
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PSComplVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PS_COMPL_ID")  // 對應資料庫的 PS_COMPL_ID 欄位
    private Integer psComplId;  // 檢舉單編號

    @Column(name = "PS_ID")  // 對應資料庫的 PS_ID 欄位
    private Integer psId;  // 保母編號

    @Column(name = "MEB_ID")  // 對應資料庫的 MEB_ID 欄位
    private Integer mebId;  // 會員編號

    @Column(name = "PS_COMPL_DATE")  // 對應資料庫的 PS_COMPL_DATE 欄位
    private LocalDateTime psComplDate;  // 檢舉日期，使用 LocalDateTime 處理日期時間

    @Column(name = "PS_COMPL_RESULT")  // 對應資料庫的 PS_COMPL_RESULT 欄位
    @NotEmpty(message = "請填寫檢舉處理結果")
    @Size(max = 255, message = "處理結果不能超過 255 個字元")
    private String psComplResult;  // 檢舉處理結果

    @Column(name = "PS_COMPL_RES_DATE")  // 對應資料庫的 PS_COMPL_RES_DATE 欄位
    private LocalDateTime psComplResDate;  // 檢舉處理日期，使用 LocalDateTime 處理日期時間

    @Column(name = "PS_COMPL_DES")  // 對應資料庫的 PS_COMPL_DES 欄位
    @NotEmpty(message = "請填寫檢舉描述")
    @Size(max = 255, message = "描述不能超過 255 個字元")
    private String psComplDes;  // 檢舉描述

    @Column(name = "PS_COMPL_STATUS")  // 對應資料庫的 PS_COMPL_STATUS 欄位
    @Size(min = 1, max = 1, message = "狀態只能是 0 或 1")
    private String psComplStatus = "0";  // 案件處理狀態，預設值為 0: 未處理

}