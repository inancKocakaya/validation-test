package com.kocakaya.validation;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;

/**
 * Classe de base des règles de validation des objets de domaine.
 *
 * @param <T> objet à valider
 * @param <P> Payload de validation (objet racine)
 */
public abstract class ValidationRule<T, P> {

    @Getter
    @Setter
    private HibernateConstraintValidatorContext hibernateContext;

    @SuppressWarnings("unchecked")
    public P getRoot() {
        return (P) hibernateContext.getConstraintValidatorPayload(Object.class);
    }

    @SuppressWarnings({"unchecked"})
    public boolean internalValidation(Object value) {
        return isValid((T) value);
    }

    public abstract boolean isValid(T value);
}