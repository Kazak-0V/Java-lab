package com.example.animalshelter.repository;

import com.example.animalshelter.entity.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для работы с таблицей "usynovleniya" (Усыновления).
 * Предоставляет CRUD операции для управления записями об усыновлениях.
 *
 * <p>Наследует от {@link JpaRepository}, что автоматически предоставляет
 * стандартные методы для работы с данными:</p>
 * <ul>
 *   <li>{@code save()} - сохранение новой записи или обновление существующей</li>
 *   <li>{@code findById()} - поиск по идентификатору</li>
 *   <li>{@code findAll()} - получение всех записей</li>
 *   <li>{@code deleteById()} - удаление записи по идентификатору</li>
 *   <li>{@code count()} - подсчет количества записей</li>
 * </ul>
 *
 * <p>Методы репозитория используются в {@link com.example.animalshelter.controller.AnimalController}
 * для обработки HTTP-запросов, связанных с усыновлениями.</p>
 *
 * @version 1.0
 * @see Adoption
 * @see com.example.animalshelter.controller.AnimalController
 */
@Repository
public interface AdoptionRepository extends JpaRepository<Adoption, Long> {
}