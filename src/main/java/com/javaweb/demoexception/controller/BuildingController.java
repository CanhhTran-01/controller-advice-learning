package com.javaweb.demoexception.controller;

import com.javaweb.demoexception.exception.FieldRequiredException;
import com.javaweb.demoexception.model.BuildingDTO;
import com.javaweb.demoexception.model.ErrorResponseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BuildingController {
    @GetMapping("/api/buildings")
    public Object getBuilding(@RequestParam(value="name", required=false) String name,
                                   @RequestParam(value="address", required=false) String address,
                                   @RequestParam(value="numberOfBasement", required=false) Integer numberOfBasement){
        // --- Exception Handler ---

        // TH1: lỗi
        // System.out.println(5/0);

        // TH2: có lỗi nhưng phía FE vẫn "200 OK"
//        try {
//            System.out.println(5/0);
//        } catch (Exception ex){
//            System.out.println(ex.getMessage());
//        }

        // TH3: có lỗi, trả ra chi tiết lỗi cho phía FE nhưng phía FE vẫn "200 OK"
//        try {
//            System.out.println(5/0);
//        } catch (Exception ex){
//            ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
//            errorResponseDTO.setErrorName(ex.getMessage());
//
//            List<String> details = new ArrayList<>();
//            details.add("số nguyên không chia cho 0 được!");
//            details.add("cần củng cố lại kiến thức toán cấp 1");
//            errorResponseDTO.setDetailError(details);
//
//            return errorResponseDTO;
//        }

        BuildingDTO buildingDTO = new BuildingDTO();
        buildingDTO.setName(name);
        buildingDTO.setAddress(address);
        buildingDTO.setNumberOfBasement(numberOfBasement);

        return buildingDTO;
    }

    @PostMapping("/api/buildings")
    public Object getBuilding(@RequestBody BuildingDTO buildingDTO){
        // --- Exception Handler ---

        // TH4: giống trường hợp 3 nhưng với Exception tự xử lý (Java không có sẵn để dùng)
//        try {
//            validate(buildingDTO);
//        } catch (Exception ex) {
//            ErrorResponseDTO errorResponseDTO = new ErrorResponseDTO();
//            errorResponseDTO.setErrorName(ex.getMessage());
//
//            List<String> details = new ArrayList<>();
//            details.add("check lại name hoặc numberOfBasement xem có null hay không");
//            details.add("nhớ ôn tập kĩ 1 chút cái Exception Handler");
//            errorResponseDTO.setDetailError(details);
//
//            return errorResponseDTO;
//        }
//        return null;

        // TH5: dùng controllerAdvice để xử lý vấn đề "200 OK"
        // System.out.println(5/0);
        validate(buildingDTO);
        return null;
    }

    // nếu extends RuntimeException thì không cần throws FieldRequiredException
    public void validate(BuildingDTO buildingDTO) {
        if (buildingDTO.getName()==null || buildingDTO.getName().equals("")
                || buildingDTO.getNumberOfBasement()==null) {
            throw new FieldRequiredException("name or numberOfBasement is null!");
        }
    }
}
