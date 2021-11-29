package com.yaksun.spring_carrent.validator;

import com.yaksun.spring_carrent.model.DTO.CarDTO;
import com.yaksun.spring_carrent.model.entity.Car;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CarValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Car.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CarDTO carDTO = (CarDTO) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"model", "admin.error.model");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"brand", "admin.error.brand");
        try {
            carDTO.getClass_();
        } catch (Exception ex) {
            errors.rejectValue("class_","admin.error.class");
        }
        try {
            Double.parseDouble(carDTO.getPrice());
        } catch (NumberFormatException e) {
            errors.rejectValue("price","admin.error.price");
        }
    }
}
