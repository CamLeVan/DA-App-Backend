package com.globits.rest;

import com.globits.service.MyFirstApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/*
 * Tại sao dùng @RestController? Về bản chất, khi đánh dấu @RestController,
 * => đang đăng ký với Spring Container để nó tạo ra một Instance (Bean) nằm
 * thường trực trong bộ nhớ RAM.
 * => Khi ứng dụng khởi động, Spring quét (Scan) class này và mở một
 * "cổng logic" để sẵn sàng tiếp nhận tín hiệu từ Card mạng.
 */
@RestController
public class MyFirstApiController {

    /*
     * @Autowired: Dependency Injection (DI)
     * => Spring tự động tìm Bean "MyFirstApiService" trong kho beans
     * => Gán (Inject) vào biến này.
     * Không cần: myFirstApiService = new MyFirstApiService(); (Spring làm hộ rồi)
     */
    @Autowired
    MyFirstApiService myFirstApiService;


    /*
     * Tại sao dùng
     * Method (GET): => Lấy dữ liệu để Read, không thay đổi
     * Path (/MyFirstApi): Đây là "tọa độ" duy nhất trên mạng
     */
    @GetMapping("/MyFirstApi")
    public String MyFirstApi() {
        // Gọi Service để lấy dữ liệu (Controller chỉ điều phối, không xử lý logic)
        return myFirstApiService.getApiData();
    }

}
