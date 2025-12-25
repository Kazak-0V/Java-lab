package com.example.animalshelter.entity;

import jakarta.persistence.*;

/**
 * Класс-сущность, представляющий усыновителя животного из приюта.
 * Соответствует таблице "usynoviteli" в базе данных.
 *
 * <p>Содержит информацию о человеке, который может усыновить животное:
 * паспортные данные, ФИО и контактную информацию.</p>
 *
 * <p>Связан с классом {@link Adoption} через отношение "один ко многим",
 * так как один усыновитель может усыновить несколько животных.</p>
 *
 * @version 1.0
 * @see Animal
 * @see Adoption
 */
@Entity
@Table(name = "usynoviteli")
public class Adopter {

    /**
     * Уникальный идентификатор усыновителя.
     * Генерируется автоматически базой данных при добавлении новой записи.
     * Является первичным ключом таблицы.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Паспортные данные усыновителя.
     * Формат: серия (4 цифры) и номер (6 цифр) через пробел.
     * Пример: "4500 123456"
     *
     * <p>Поле обязательно для заполнения, соответствует столбцу "pasportnye_dannye"
     * в таблице базы данных.</p>
     */
    @Column(name = "pasportnye_dannye", nullable = false, length = 40)
    private String passportData;

    /**
     * Имя усыновителя.
     * Должно содержать только буквы русского алфавита.
     *
     * <p>Поле обязательно для заполнения, соответствует столбцу "imya"
     * в таблице базы данных.</p>
     */
    @Column(name = "imya", nullable = false, length = 40)
    private String firstName;

    /**
     * Фамилия усыновителя.
     * Должна содержать только буквы русского алфавита.
     *
     * <p>Поле обязательно для заполнения, соответствует столбцу "familia"
     * в таблице базы данных.</p>
     */
    @Column(name = "familia", nullable = false, length = 40)
    private String lastName;

    /**
     * Отчество усыновителя.
     * Может быть пустым (необязательное поле).
     * Если указано, должно содержать только буквы русского алфавита.
     *
     * <p>Соответствует столбцу "otchestvo" в таблице базы данных.</p>
     */
    @Column(name = "otchestvo", length = 40)
    private String patronymic;

    /**
     * Контактные данные усыновителя (телефон).
     * Может быть пустым (необязательное поле).
     * Рекомендуемый формат: "+7(999)123-45-67" или "89991234567".
     *
     * <p>Соответствует столбцу "kontaktnye_dannye" в таблице базы данных.</p>
     */
    @Column(name = "kontaktnye_dannye", length = 40)
    private String contactData;

    /**
     * Конструктор по умолчанию.
     * Требуется для JPA.
     */
    public Adopter() {}

    /**
     * Конструктор с основными параметрами.
     * Используется для быстрого создания объекта усыновителя.
     *
     * @param passportData паспортные данные усыновителя
     * @param firstName имя усыновителя
     * @param lastName фамилия усыновителя
     */
    public Adopter(String passportData, String firstName, String lastName) {
        this.passportData = passportData;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Возвращает уникальный идентификатор усыновителя.
     *
     * @return идентификатор усыновителя
     */
    public Long getId() {
        return id;
    }

    /**
     * Устанавливает уникальный идентификатор усыновителя.
     * Обычно не используется напрямую, так как ID генерируется базой данных.
     *
     * @param id идентификатор усыновителя
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Возвращает паспортные данные усыновителя.
     *
     * @return паспортные данные в формате "4500 123456"
     */
    public String getPassportData() {
        return passportData;
    }

    /**
     * Устанавливает паспортные данные усыновителя.
     *
     * @param passportData паспортные данные в формате "4500 123456"
     */
    public void setPassportData(String passportData) {
        this.passportData = passportData;
    }

    /**
     * Возвращает имя усыновителя.
     *
     * @return имя усыновителя
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Устанавливает имя усыновителя.
     *
     * @param firstName имя усыновителя
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Возвращает фамилию усыновителя.
     *
     * @return фамилия усыновителя
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Устанавливает фамилию усыновителя.
     *
     * @param lastName фамилия усыновителя
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Возвращает отчество усыновителя.
     * Может возвращать null, если отчество не указано.
     *
     * @return отчество усыновителя или null
     */
    public String getPatronymic() {
        return patronymic;
    }

    /**
     * Устанавливает отчество усыновителя.
     *
     * @param patronymic отчество усыновителя (может быть null)
     */
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    /**
     * Возвращает контактные данные усыновителя.
     * Может возвращать null, если контактные данные не указаны.
     *
     * @return телефон усыновителя или null
     */
    public String getContactData() {
        return contactData;
    }

    /**
     * Устанавливает контактные данные усыновителя.
     *
     * @param contactData телефон усыновителя (может быть null)
     */
    public void setContactData(String contactData) {
        this.contactData = contactData;
    }

    /**
     * Возвращает строковое представление объекта усыновителя.
     * Формат: "Фамилия Имя [Отчество]"
     *
     * @return строковое представление усыновителя
     */
    @Override
    public String toString() {
        String fullName = lastName + " " + firstName;
        if (patronymic != null && !patronymic.isEmpty()) {
            fullName += " " + patronymic;
        }
        return fullName;
    }

    /**
     * Возвращает полное ФИО усыновителя.
     * Удобный метод для отображения в интерфейсе.
     *
     * @return полное ФИО в формате "Иванов Иван Иванович"
     */
    public String getFullName() {
        StringBuilder fullName = new StringBuilder();
        if (lastName != null) {
            fullName.append(lastName);
        }
        if (firstName != null) {
            fullName.append(" ").append(firstName);
        }
        if (patronymic != null && !patronymic.isEmpty()) {
            fullName.append(" ").append(patronymic);
        }
        return fullName.toString().trim();
    }

    /**
     * Проверяет, является ли усыновитель "полным" (заполнены все обязательные поля).
     * Используется для валидации перед сохранением в базу данных.
     *
     * @return true если все обязательные поля заполнены, иначе false
     */
    public boolean isValid() {
        return passportData != null && !passportData.trim().isEmpty() &&
                firstName != null && !firstName.trim().isEmpty() &&
                lastName != null && !lastName.trim().isEmpty();
    }
}