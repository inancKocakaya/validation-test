package com.kocakaya.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.groups.Default;
import lombok.AllArgsConstructor;
import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.HibernateValidatorConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class Validator<T> {

    private final Class<?> validationProfile;

    public Validator() {
        validationProfile = null;
    }

    public void valider(T objet) {
        var validationMessages = getMessagesValidation(objet);

        if (!validationMessages.isEmpty()) {
            throw new ValidationException(validationMessages);
        }
    }

    public List<String> getMessagesValidation(T objet) {
        var validationMessages = new ArrayList<>(hibernateValidation(objet));
        customValidation(objet, validationMessages);
        return validationMessages;
    }

    @SuppressWarnings({"unused", "java:S1186"})
    protected void customValidation(T objet, List<String> erreurs) {
    }


    protected List<String> hibernateValidation(T objet) {
        try (ValidatorFactory factory = validationProvider(objet).buildValidatorFactory()) {
            var validator = factory.getValidator();

            return validator.validate(objet, getValidationProfiles())
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .toList();
        }
    }

    protected HibernateValidatorConfiguration validationProvider(T objet) {
        return Validation.byProvider(HibernateValidator.class)
                .configure()
                .constraintValidatorPayload(objet);
    }

    protected Class<?>[] getValidationProfiles() {
        var validationProfiles = new ArrayList<Class<?>>();
        validationProfiles.add(Default.class);
        Optional.ofNullable(getValidationProfile()).ifPresent(validationProfiles::add);
        return validationProfiles.toArray(new Class<?>[]{});
    }

    protected Class<?> getValidationProfile() {
        return validationProfile;
    }
}