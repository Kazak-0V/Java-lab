package com.example.animalshelter.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Класс-сущность, представляющий таблицу "zhivotnye" в базе данных.
 * Содержит информацию о животных, находящихся в приюте.
 *
 * <p>Каждое животное имеет уникальный идентификатор, кличку, дату поступления,
 * вид, породу, возраст, пол и текущий статус.</p>
 *
 * @version 1.0
 * @see Adopter
 * @see MedProcedure
 * @see Adoption
 */
@Entity
@Table(name = "zhivotnye")
public class Animal {

    /**
     * Уникальный идентификатор животного.
     * Генерируется автоматически базой данных.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Кличка животного.
     * Обязательное поле.
     */
    @Column(name = "klichka", nullable = false, length = 40)
    private String name;

    /**
     * Дата поступления животного в приют.
     * Обязательное поле.
     */
    @Column(name = "data_postupleniya", nullable = false)
    private LocalDate admissionDate;

    /**
     * Вид животного.
     * Допустимые значения: "кошка" или "собака".
     * Обязательное поле.
     */
    @Column(name = "vid", nullable = false, length = 40)
    private String type;

    /**
     * Порода животного.
     * Необязательное поле, максимальная длина - 40 символов.
     */
    @Column(name = "poroda", length = 40)
    private String breed;

    /**
     * Возраст животного в месяцах.
     * Обязательное поле, должно быть положительным числом.
     */
    @Column(name = "vozrast", nullable = false)
    private Integer ageMonths;

    /**
     * Пол животного.
     * Допустимые значения: "м" (мужской) или "ж" (женский).
     * Обязательное поле.
     */
    @Column(name = "pol", nullable = false, length = 40)
    private String gender;

    /**
     * Текущий статус животного.
     * Допустимые значения:
     * <ul>
     *   <li>"на карантине" - животное на карантине после поступления</li>
     *   <li>"на лечении" - животное проходит лечение</li>
     *   <li>"готов к усыновлению" - животное готово для усыновления</li>
     *   <li>"усыновлен" - животное было усыновлено</li>
     * </ul>
     * Обязательное поле.
     */
    @Column(name = "status", nullable = false, length = 40)
    private String status;

    /**
     * Конструктор по умолчанию.
     * Требуется для JPA.
     */
    public Animal() {}

    /**
     * Конструктор с основными параметрами.
     *
     * @param name кличка животного
     * @param type вид животного ("кошка" или "собака")
     * @param ageMonths возраст в месяцах
     * @param gender пол животного ("м" или "ж")
     */
    public Animal(String name, String type, Integer ageMonths, String gender) {
        this.name = name;
        this.type = type;
        this.ageMonths = ageMonths;
        this.gender = gender;
        this.admissionDate = LocalDate.now();
        this.status = "на карантине";
    }

    /**
     * Возвращает идентификатор животного.
     *
     * @return уникальный идентификатор
     */
    public Long getId() {
        return id;
    }

    /**
     * Устанавливает идентификатор животного.
     *
     * @param id уникальный идентификатор
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Возвращает кличку животного.
     *
     * @return кличка животного
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает кличку животного.
     *
     * @param name кличка животного
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Возвращает дату поступления животного в приют.
     *
     * @return дата поступления
     */
    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    /**
     * Устанавливает дату поступления животного в приют.
     *
     * @param admissionDate дата поступления
     */
    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    /**
     * Возвращает вид животного.
     *
     * @return вид животного ("кошка" или "собака")
     */
    public String getType() {
        return type;
    }

    /**
     * Устанавливает вид животного.
     *
     * @param type вид животного ("кошка" или "собака")
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Возвращает породу животного.
     *
     * @return порода животного, может быть null
     */
    public String getBreed() {
        return breed;
    }

    /**
     * Устанавливает породу животного.
     *
     * @param breed порода животного
     */
    public void setBreed(String breed) {
        this.breed = breed;
    }

    /**
     * Возвращает возраст животного в месяцах.
     *
     * @return возраст в месяцах
     */
    public Integer getAgeMonths() {
        return ageMonths;
    }

    /**
     * Устанавливает возраст животного в месяцах.
     *
     * @param ageMonths возраст в месяцах
     * @throws IllegalArgumentException если возраст отрицательный
     */
    public void setAgeMonths(Integer ageMonths) {
        if (ageMonths != null && ageMonths < 0) {
            throw new IllegalArgumentException("Возраст не может быть отрицательным");
        }
        this.ageMonths = ageMonths;
    }

    /**
     * Возвращает пол животного.
     *
     * @return пол животного ("м" или "ж")
     */
    public String getGender() {
        return gender;
    }

    /**
     * Устанавливает пол животного.
     *
     * @param gender пол животного ("м" или "ж")
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Возвращает текущий статус животного.
     *
     * @return статус животного
     */
    public String getStatus() {
        return status;
    }

    /**
     * Устанавливает текущий статус животного.
     *
     * @param status статус животного
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Проверяет, готово ли животное к усыновлению.
     *
     * @return true если статус "готов к усыновлению", иначе false
     */
    public boolean isReadyForAdoption() {
        return "готов к усыновлению".equals(status);
    }

    /**
     * Проверяет, было ли животное усыновлено.
     *
     * @return true если статус "усыновлен", иначе false
     */
    public boolean isAdopted() {
        return "усыновлен".equals(status);
    }

    /**
     * Возвращает строковое представление объекта Animal.
     *
     * @return строка в формате "Animal{id=..., name='...', type='...', status='...'}"
     */
    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    /**
     * Сравнивает данное животное с другим объектом.
     * Два животных считаются равными, если у них одинаковый ID.
     *
     * @param o объект для сравнения
     * @return true если объекты равны, иначе false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return id != null && id.equals(animal.id);
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