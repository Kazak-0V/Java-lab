package com.example.animalshelter.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Сущность, представляющая таблицу "usynovleniya" (Усыновления) в базе данных.
 * Содержит информацию о фактах усыновления животных из приюта.
 *
 * <p>Каждая запись связывает одно животное с одним усыновителем
 * и фиксирует дату усыновления.</p>
 *
 * @version 1.0
 * @see Animal
 * @see Adopter
 */
@Entity
@Table(name = "usynovleniya")
public class Adoption {

    /**
     * Уникальный идентификатор записи об усыновлении.
     * Генерируется автоматически базой данных при вставке новой записи.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Животное, которое было усыновлено.
     * Связь один-к-одному с таблицей zhivotnye.
     */
    @OneToOne
    @JoinColumn(name = "id_zhivotnogo", nullable = false)
    private Animal animal;

    /**
     * Усыновитель, который взял животное из приюта.
     * Связь многие-к-одному с таблицей usynoviteli.
     */
    @ManyToOne
    @JoinColumn(name = "id_usynovitelya", nullable = false)
    private Adopter adopter;

    /**
     * Дата официального оформления усыновления.
     * <p>Формат: ГГГГ-ММ-ДД</p>
     */
    @Column(name = "data_usynovleniya", nullable = false)
    private LocalDate adoptionDate;

    /**
     * Конструктор по умолчанию.
     * Требуется для JPA.
     */
    public Adoption() {}

    /**
     * Конструктор с параметрами для создания записи об усыновлении.
     *
     * @param animal животное, которое усыновляют
     * @param adopter усыновитель
     * @param adoptionDate дата усыновления
     */
    public Adoption(Animal animal, Adopter adopter, LocalDate adoptionDate) {
        this.animal = animal;
        this.adopter = adopter;
        this.adoptionDate = adoptionDate;
    }

    /**
     * Возвращает уникальный идентификатор усыновления.
     *
     * @return идентификатор записи
     */
    public Long getId() {
        return id;
    }

    /**
     * Устанавливает уникальный идентификатор усыновления.
     *
     * @param id новый идентификатор записи
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Возвращает животное, которое было усыновлено.
     *
     * @return объект Animal
     */
    public Animal getAnimal() {
        return animal;
    }

    /**
     * Устанавливает животное для усыновления.
     *
     * @param animal объект Animal
     */
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    /**
     * Возвращает усыновителя.
     *
     * @return объект Adopter
     */
    public Adopter getAdopter() {
        return adopter;
    }

    /**
     * Устанавливает усыновителя.
     *
     * @param adopter объект Adopter
     */
    public void setAdopter(Adopter adopter) {
        this.adopter = adopter;
    }

    /**
     * Возвращает дату усыновления.
     *
     * @return дата усыновления
     */
    public LocalDate getAdoptionDate() {
        return adoptionDate;
    }

    /**
     * Устанавливает дату усыновления.
     *
     * @param adoptionDate новая дата усыновления
     */
    public void setAdoptionDate(LocalDate adoptionDate) {
        this.adoptionDate = adoptionDate;
    }

    /**
     * Возвращает строковое представление объекта усыновления.
     * Используется для отладки и логирования.
     *
     * @return строковое представление в формате:
     *         "Adoption{id=X, animal=ИмяЖивотного, adopter=ФамилияУсыновителя, adoptionDate=дата}"
     */
    @Override
    public String toString() {
        return "Adoption{" +
                "id=" + id +
                ", animal=" + (animal != null ? animal.getName() : "null") +
                ", adopter=" + (adopter != null ? adopter.getLastName() : "null") +
                ", adoptionDate=" + adoptionDate +
                '}';
    }

    /**
     * Проверяет, было ли усыновление совершено в текущем году.
     *
     * @return true если усыновление в текущем году, иначе false
     */
    public boolean isThisYear() {
        return adoptionDate != null &&
                adoptionDate.getYear() == LocalDate.now().getYear();
    }

    /**
     * Проверяет, является ли усыновитель тем же человеком, что и в другом усыновлении.
     *
     * @param otherAdoption другое усыновление для сравнения
     * @return true если усыновители совпадают, иначе false
     */
    public boolean hasSameAdopter(Adoption otherAdoption) {
        return this.adopter != null &&
                otherAdoption != null &&
                otherAdoption.getAdopter() != null &&
                this.adopter.getId().equals(otherAdoption.getAdopter().getId());
    }
}