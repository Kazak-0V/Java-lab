package com.example.animalshelter.repository;

import com.example.animalshelter.entity.Adoption;
import com.example.animalshelter.entity.MedProcedure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Репозиторий для работы с таблицей медицинских процедур (medicinskie_procedury).
 * Управляет записями о медицинских процедурах, проведенных животным в приюте.
 *
 * <p><strong>Таблица:</strong> medicinskie_procedury</p>
 * <p><strong>Описание:</strong> Журнал медицинских процедур для отслеживания здоровья животных.</p>
 *
 * @version 1.0
 * @see MedProcedure
 * @see com.example.animalshelter.controller.AnimalController
 */
@Repository
public interface MedProcedureRepository extends JpaRepository<MedProcedure, Long> {

    /**
     * Находит все медицинские процедуры для указанного животного.
     *
     * @param animalId идентификатор животного
     * @return список медицинских процедур для данного животного
     */
    List<MedProcedure> findByAnimalId(Long animalId);
}