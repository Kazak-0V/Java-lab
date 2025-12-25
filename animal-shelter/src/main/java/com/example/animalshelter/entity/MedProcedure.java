package com.example.animalshelter.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Класс-сущность, представляющий медицинскую процедуру животного.
 * Соответствует таблице "medicinskie_procedury" в базе данных.
 *
 * <p>Каждая медицинская процедура связана с конкретным животным
 * и содержит информацию о типе процедуры и дате проведения.</p>
 *
 * @version 1.0
 * @see Animal
 */
@Entity
@Table(name = "medicinskie_procedury")
public class MedProcedure {

    /**
     * Уникальный идентификатор медицинской процедуры.
     * Генерируется автоматически базой данных.
     * <br>Соответствует столбцу: id</p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Тип проведенной медицинской процедуры.
     *
     * <p>Допустимые значения:
     * <ul>
     *   <li>вакцинация</li>
     *   <li>стерилизация</li>
     *   <li>обработка</li>
     *   <li>осмотр</li>
     *   <li>лечение</li>
     * </ul></p>
     *
     * <br>Соответствует столбцу: tip_procedury</p>
     */
    @Column(name = "tip_procedury", nullable = false, length = 40)
    private String procedureType;

    /**
     * Дата проведения медицинской процедуры.
     *
     * <p>Формат: ГГГГ-ММ-ДД
     * <br>Не может быть в будущем</p>
     *
     * <br>Соответствует столбцу: data_provedeniya</p>
     */
    @Column(name = "data_provedeniya", nullable = false)
    private LocalDate procedureDate;

    /**
     * Животное, которому проведена процедура.
     *
     * <p>Связь: многие процедуры к одному животному.
     * <br>Внешний ключ на таблицу zhivotnye</p>
     *
     * @see Animal
     */
    @ManyToOne
    @JoinColumn(name = "id_zhivotnogo", nullable = false)
    private Animal animal;

    /**
     * Конструктор по умолчанию.
     * Требуется для JPA.
     */
    public MedProcedure() {}

    /**
     * Конструктор с параметрами для создания новой медицинской процедуры.
     *
     * @param procedureType тип медицинской процедуры
     * @param procedureDate дата проведения процедуры
     * @param animal животное, которому проведена процедура
     */
    public MedProcedure(String procedureType, LocalDate procedureDate, Animal animal) {
        this.procedureType = procedureType;
        this.procedureDate = procedureDate;
        this.animal = animal;
    }

    /**
     * Возвращает уникальный идентификатор процедуры.
     *
     * @return идентификатор процедуры
     */
    public Long getId() {
        return id;
    }

    /**
     * Возвращает тип медицинской процедуры.
     *
     * @return тип процедуры (вакцинация, стерилизация и т.д.)
     */
    public String getProcedureType() {
        return procedureType;
    }

    /**
     * Возвращает дату проведения процедуры.
     *
     * @return дата процедуры
     */
    public LocalDate getProcedureDate() {
        return procedureDate;
    }

    /**
     * Возвращает животное, которому проведена процедура.
     *
     * @return объект Animal
     */
    public Animal getAnimal() {
        return animal;
    }

    /**
     * Устанавливает уникальный идентификатор процедуры.
     *
     * @param id новый идентификатор
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Устанавливает тип медицинской процедуры.
     *
     * @param procedureType новый тип процедуры
     */
    public void setProcedureType(String procedureType) {
        this.procedureType = procedureType;
    }

    /**
     * Устанавливает дату проведения процедуры.
     *
     * @param procedureDate новая дата процедуры
     */
    public void setProcedureDate(LocalDate procedureDate) {
        this.procedureDate = procedureDate;
    }

    /**
     * Устанавливает животное для процедуры.
     *
     * @param animal животное, которому проведена процедура
     */
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    /**
     * Возвращает строковое представление объекта MedProcedure.
     *
     * @return строка в формате: "MedProcedure{id=X, procedureType='Y', procedureDate=Z, animal=W}"
     */
    @Override
    public String toString() {
        return "MedProcedure{" +
                "id=" + id +
                ", procedureType='" + procedureType + '\'' +
                ", procedureDate=" + procedureDate +
                ", animal=" + (animal != null ? animal.getName() : "null") +
                '}';
    }

    /**
     * Проверяет равенство объектов MedProcedure.
     * Два объекта равны, если имеют одинаковый id.
     *
     * @param o объект для сравнения
     * @return true если объекты равны, false в противном случае
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedProcedure that = (MedProcedure) o;
        return id != null && id.equals(that.id);
    }

    /**
     * Возвращает хэш-код объекта.
     *
     * @return хэш-код
     */
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}