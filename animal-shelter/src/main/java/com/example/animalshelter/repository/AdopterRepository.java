package com.example.animalshelter.repository;

import com.example.animalshelter.entity.Adopter;
import com.example.animalshelter.entity.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для работы с таблицей усыновителей (usynoviteli).
 * Обеспечивает доступ к данным о потенциальных и действующих усыновителях животных.
 *
 * <p><strong>Таблица:</strong> usynoviteli</p>
 * <p><strong>Описание:</strong> Содержит информацию о лицах, усыновивших или планирующих усыновить животных.</p>
 *
 * <p><strong>Связи:</strong></p>
 * <ul>
 *   <li>С таблицей usynovleniya (один-ко-многим)</li>
 * </ul>
 *
 * @version 1.0
 * @see Adopter
 * @see com.example.animalshelter.controller.AnimalController
 */
@Repository
public interface AdopterRepository extends JpaRepository<Adopter, Long> {
}