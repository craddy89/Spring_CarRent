package com.yaksun.spring_carrent.validator;

import com.yaksun.spring_carrent.model.DTO.RentFormDTO;
import com.yaksun.spring_carrent.model.entity.RentForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.concurrent.TimeUnit;

@Component
public class RentFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return RentForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RentFormDTO rentForm = (RentFormDTO) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"passport", "rent.error.passport");
        if(rentForm.getPassport().length() != 9)
            errors.rejectValue("passport","rent.error.passport");
        double dateValidating = TimeUnit.DAYS.convert(rentForm.getToDate().getTime() - rentForm.getFromDate().getTime(), TimeUnit.MILLISECONDS);
        if(dateValidating<0)
            errors.rejectValue("toDate","rent.error.date");
    }
}
