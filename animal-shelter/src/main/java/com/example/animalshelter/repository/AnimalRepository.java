package com.example.animalshelter.repository;

import com.example.animalshelter.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для работы с таблицей животных (zhivotnye).
 * Предоставляет CRUD операции и пользовательские запросы
 * для управления данными о животных в приюте.
 *
 * <p><strong>Таблица:</strong> zhivotnye</p>
 * <p><strong>Описание:</strong> Содержит информацию о животных, находящихся в приюте.</p>
 *

 * <p><strong>Связи:</strong></p>
 * <ul>
 *   <li>С таблицей medicinskie_procedury (один-ко-многим)</li>
 *   <li>С таблицей usynovleniya (один-к-одному)</li>
 * </ul>
 *
 * @version 1.0
 * @see Animal
 * @see com.example.animalshelter.controller.AnimalController
 */
@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
}