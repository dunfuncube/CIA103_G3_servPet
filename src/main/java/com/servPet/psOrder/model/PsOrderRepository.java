package com.servPet.psOrder.model;
//保母服務訂單

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PsOrderRepository extends JpaRepository<PsOrderVO, Integer> {
    // 預約表單填寫送出後,頁面中可預約日期時段即不顯示,除非被美容師或會員取消訂單才會重新釋出
    // 預約表單送出,美容師後台及會員預約管理會顯示其預約資訊,美容師後台需有確認訂單及取消訂單之選項
    // 預約表單會自動帶出總消費金額及尚餘儲值金額,加減服務連動計算,未選擇任何服務項目不得送出訂單
    // 預約表單送出後自動扣除儲值金,並顯示餘額
    // 若消費金額<儲值金額則頁面跳轉儲值金儲值頁面(紹輔),儲值成功或失敗皆自動跳轉回預約畫面,若不儲值直接點選送出預約則顯示提示"儲值金餘額不足"

    // 根據保母編號查詢訂單
    @Query(value = "from PsOrderVO where psVO=?1 order by psoId")
    List<PsOrderVO> findByPsId(int psId);

    // 依照會員編號查詢
    @Query(value = "from PsOrderVO where mebVO=?1 order by psoId")
    List<PsOrderVO> findByMebId(int mebId);

    // 依照訂單狀態查詢(未完成.已完成.進行中.已取消)
    @Query(value = "from PsOrderVO where bookingStatus=?1 order by psoId")
    List<PsOrderVO> findByBookingStatus( String bookingStatus);

}