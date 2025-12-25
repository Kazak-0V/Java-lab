package com.example.animalshelter.controller;

import com.example.animalshelter.entity.Adoption;
import com.example.animalshelter.entity.Animal;
import com.example.animalshelter.entity.Adopter;
import com.example.animalshelter.entity.MedProcedure;
import com.example.animalshelter.repository.AdoptionRepository;
import com.example.animalshelter.repository.AnimalRepository;
import com.example.animalshelter.repository.AdopterRepository;
import com.example.animalshelter.repository.MedProcedureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Основной контроллер приложения "Система управления приютом для животных".
 * Обрабатывает все HTTP-запросы для работы с базой данных приюта.
 * <p>
 * Контроллер обеспечивает CRUD операции для четырёх основных сущностей:
 * - Животные (Animal)
 * - Усыновители (Adopter)
 * - Медицинские процедуры (MedProcedure)
 * - Усыновления (Adoption)
 * </p>
 *
 * @version 1.0
 */
@Controller
public class AnimalController {

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private AdopterRepository adopterRepository;

    @Autowired
    private MedProcedureRepository medProcedureRepository;

    @Autowired
    private AdoptionRepository adoptionRepository;

    /**
     * Отображает главную страницу приложения со статистикой.
     *
     * @param model объект Model для передачи данных в представление
     * @return имя шаблона домашней страницы
     */
    @GetMapping("/")
    public String home(Model model) {
        long animalsCount = animalRepository.count();
        long adoptersCount = adopterRepository.count();
        long proceduresCount = medProcedureRepository.count();
        long adoptionsCount = adoptionRepository.count();

        model.addAttribute("animalsCount", animalsCount);
        model.addAttribute("adoptersCount", adoptersCount);
        model.addAttribute("proceduresCount", proceduresCount);
        model.addAttribute("adoptionsCount", adoptionsCount);
        return "home";
    }

    /**
     * Отображает список всех животных.
     *
     * @param model объект Model для передачи данных в представление
     * @return имя шаблона страницы животных
     */
    @GetMapping("/animals")
    public String listAnimals(Model model) {
        List<Animal> animals = animalRepository.findAll();
        model.addAttribute("animals", animals);
        model.addAttribute("animal", new Animal());
        return "animals";
    }

    /**
     * Добавляет новое животное в базу данных.
     *
     * @param animal объект Animal с данными из формы
     * @return перенаправление на страницу списка животных
     */
    @PostMapping("/animals/add")
    public String addAnimal(@ModelAttribute Animal animal) {
        if (animal.getAdmissionDate() == null) {
            animal.setAdmissionDate(LocalDate.now());
        }
        animalRepository.save(animal);
        return "redirect:/animals";
    }

    /**
     * Удаляет животное по идентификатору.
     *
     * @param id идентификатор животного
     * @return перенаправление на страницу списка животных
     */
    @GetMapping("/animals/delete/{id}")
    public String deleteAnimal(@PathVariable Long id) {
        animalRepository.deleteById(id);
        return "redirect:/animals";
    }

    /**
     * Отображает форму для редактирования животного.
     *
     * @param id идентификатор животного
     * @param model объект Model для передачи данных в представление
     * @return имя шаблона формы редактирования животного
     */
    @GetMapping("/animals/edit/{id}")
    public String showEditAnimalForm(@PathVariable Long id, Model model) {
        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Животное не найдено"));
        model.addAttribute("animal", animal);
        model.addAttribute("animals", animalRepository.findAll());
        return "animals-edit";
    }

    /**
     * Обновляет данные животного в базе данных.
     *
     * @param animal объект Animal с обновленными данными
     * @return перенаправление на страницу списка животных
     */
    @PostMapping("/animals/update")
    public String updateAnimal(@ModelAttribute Animal animal) {
        animalRepository.save(animal);
        return "redirect:/animals";
    }

    /**
     * Отображает список всех усыновителей.
     *
     * @param model объект Model для передачи данных в представление
     * @return имя шаблона страницы усыновителей
     */
    @GetMapping("/adopters")
    public String listAdopters(Model model) {
        List<Adopter> adopters = adopterRepository.findAll();
        model.addAttribute("adopters", adopters);
        model.addAttribute("adopter", new Adopter());
        return "adopters";
    }

    /**
     * Добавляет нового усыновителя в базу данных.
     *
     * @param adopter объект Adopter с данными из формы
     * @return перенаправление на страницу списка усыновителей
     */
    @PostMapping("/adopters/add")
    public String addAdopter(@ModelAttribute Adopter adopter) {
        adopterRepository.save(adopter);
        return "redirect:/adopters";
    }

    /**
     * Удаляет усыновителя по идентификатору.
     *
     * @param id идентификатор усыновителя
     * @return перенаправление на страницу списка усыновителей
     */
    @GetMapping("/adopters/delete/{id}")
    public String deleteAdopter(@PathVariable Long id) {
        adopterRepository.deleteById(id);
        return "redirect:/adopters";
    }

    /**
     * Отображает форму для редактирования усыновителя.
     *
     * @param id идентификатор усыновителя
     * @param model объект Model для передачи данных в представление
     * @return имя шаблона формы редактирования усыновителя
     */
    @GetMapping("/adopters/edit/{id}")
    public String showEditAdopterForm(@PathVariable Long id, Model model) {
        Adopter adopter = adopterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Усыновитель не найден"));
        model.addAttribute("adopter", adopter);
        model.addAttribute("adopters", adopterRepository.findAll());
        return "adopters-edit";
    }

    /**
     * Обновляет данные усыновителя в базе данных.
     *
     * @param adopter объект Adopter с обновленными данными
     * @return перенаправление на страницу списка усыновителей
     */
    @PostMapping("/adopters/update")
    public String updateAdopter(@ModelAttribute Adopter adopter) {
        adopterRepository.save(adopter);
        return "redirect:/adopters";
    }

    /**
     * Отображает список всех медицинских процедур.
     *
     * @param model объект Model для передачи данных в представление
     * @return имя шаблона страницы медицинских процедур
     */
    @GetMapping("/procedures")
    public String listProcedures(Model model) {
        List<MedProcedure> procedures = medProcedureRepository.findAll();
        List<Animal> animals = animalRepository.findAll();

        model.addAttribute("procedures", procedures);
        model.addAttribute("procedure", new MedProcedure());
        model.addAttribute("animals", animals);
        return "procedures";
    }

    /**
     * Добавляет новую медицинскую процедуру в базу данных.
     * Проверяет возможность повторной стерилизации.
     *
     * @param procedureType тип медицинской процедуры
     * @param procedureDate дата проведения процедуры
     * @param animalId идентификатор животного
     * @param model объект Model для передачи данных в представление
     * @return перенаправление на страницу списка процедур
     */
    @PostMapping("/procedures/add")
    public String addProcedure(@RequestParam String procedureType,
                               @RequestParam String procedureDate,
                               @RequestParam Long animalId,
                               Model model) {

        try {
            Animal animal = animalRepository.findById(animalId)
                    .orElseThrow(() -> new RuntimeException("Животное не найдено"));

            if ("стерилизация".equals(procedureType)) {
                boolean alreadySterilized = medProcedureRepository.findByAnimalId(animalId)
                        .stream()
                        .anyMatch(proc -> "стерилизация".equals(proc.getProcedureType()));

                if (alreadySterilized) {
                    model.addAttribute("error", "Это животное уже стерилизовано!");
                    model.addAttribute("procedures", medProcedureRepository.findAll());
                    model.addAttribute("animals", animalRepository.findAll());
                    return "procedures";
                }
            }

            MedProcedure procedure = new MedProcedure();
            procedure.setProcedureType(procedureType);
            procedure.setProcedureDate(LocalDate.parse(procedureDate));
            procedure.setAnimal(animal);

            medProcedureRepository.save(procedure);
            return "redirect:/procedures";

        } catch (Exception e) {
            model.addAttribute("error", "Ошибка: " + e.getMessage());
            model.addAttribute("procedures", medProcedureRepository.findAll());
            model.addAttribute("animals", animalRepository.findAll());
            return "procedures";
        }
    }

    /**
     * Удаляет медицинскую процедуру по идентификатору.
     *
     * @param id идентификатор медицинской процедуры
     * @return перенаправление на страницу списка процедур
     */
    @GetMapping("/procedures/delete/{id}")
    public String deleteProcedure(@PathVariable Long id) {
        medProcedureRepository.deleteById(id);
        return "redirect:/procedures";
    }

    /**
     * Отображает медицинские процедуры конкретного животного.
     *
     * @param animalId идентификатор животного
     * @param model объект Model для передачи данных в представление
     * @return имя шаблона страницы процедур животного
     */
    @GetMapping("/procedures/animal/{animalId}")
    public String getProceduresByAnimal(@PathVariable Long animalId, Model model) {
        Animal animal = animalRepository.findById(animalId).orElse(null);
        List<MedProcedure> procedures = medProcedureRepository.findByAnimalId(animalId);

        model.addAttribute("animal", animal);
        model.addAttribute("procedures", procedures);
        return "animal-procedures";
    }

    /**
     * Обновляет данные медицинской процедуры в базе данных.
     *
     * @param procedure объект MedProcedure с обновленными данными
     * @param animalId идентификатор животного
     * @return перенаправление на страницу списка процедур
     */
    @PostMapping("/procedures/update")
    public String updateProcedure(@ModelAttribute MedProcedure procedure,
                                  @RequestParam Long animalId) {

        Animal animal = animalRepository.findById(animalId)
                .orElseThrow(() -> new RuntimeException("Животное не найдено"));

        if ("стерилизация".equals(procedure.getProcedureType())) {
            boolean alreadySterilized = medProcedureRepository.findByAnimalId(animalId)
                    .stream()
                    .anyMatch(proc -> "стерилизация".equals(proc.getProcedureType()) &&
                            !proc.getId().equals(procedure.getId()));

            if (alreadySterilized) {
                return "redirect:/procedures?error=Это животное уже стерилизовано";
            }
        }

        procedure.setAnimal(animal);
        medProcedureRepository.save(procedure);
        return "redirect:/procedures";
    }

    /**
     * Отображает список всех усыновлений.
     *
     * @param model объект Model для передачи данных в представление
     * @return имя шаблона страницы усыновлений
     */
    @GetMapping("/adoptions")
    public String listAdoptions(Model model) {
        model.addAttribute("adoptions", adoptionRepository.findAll());
        model.addAttribute("adoption", new Adoption());
        model.addAttribute("animals", animalRepository.findAll());
        model.addAttribute("adopters", adopterRepository.findAll());
        return "adoptions";
    }

    /**
     * Добавляет новое усыновление в базу данных.
     * Проверяет, не усыновлено ли уже животное.
     * Обновляет статус животного на "усыновлен".
     *
     * @param animalId идентификатор животного
     * @param adopterId идентификатор усыновителя
     * @param adoptionDate дата усыновления
     * @param model объект Model для передачи данных в представление
     * @return перенаправление на страницу списка усыновлений
     */
    @PostMapping("/adoptions/add")
    public String addAdoption(@RequestParam Long animalId,
                              @RequestParam Long adopterId,
                              @RequestParam String adoptionDate,
                              Model model) {

        try {
            Animal animal = animalRepository.findById(animalId)
                    .orElseThrow(() -> new RuntimeException("Животное не найдено"));

            Adopter adopter = adopterRepository.findById(adopterId)
                    .orElseThrow(() -> new RuntimeException("Усыновитель не найден"));

            boolean alreadyAdopted = adoptionRepository.findAll().stream()
                    .anyMatch(adopt -> adopt.getAnimal().getId().equals(animalId));

            if (alreadyAdopted) {
                model.addAttribute("error", "Это животное уже усыновлено!");
                return listAdoptions(model);
            }

            Adoption adoption = new Adoption();
            adoption.setAnimal(animal);
            adoption.setAdopter(adopter);
            adoption.setAdoptionDate(LocalDate.parse(adoptionDate));

            animal.setStatus("усыновлен");
            animalRepository.save(animal);

            adoptionRepository.save(adoption);
            return "redirect:/adoptions";

        } catch (Exception e) {
            model.addAttribute("error", "Ошибка: " + e.getMessage());
            return listAdoptions(model);
        }
    }

    /**
     * Удаляет усыновление по идентификатору.
     * Возвращает статус животного на "готов к усыновлению".
     *
     * @param id идентификатор усыновления
     * @return перенаправление на страницу списка усыновлений
     */
    @GetMapping("/adoptions/delete/{id}")
    public String deleteAdoption(@PathVariable Long id) {
        try {
            Adoption adoption = adoptionRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Усыновление не найдено"));

            Animal animal = adoption.getAnimal();
            animal.setStatus("готов к усыновлению");
            animalRepository.save(animal);

            adoptionRepository.deleteById(id);
        } catch (Exception e) {
        }
        return "redirect:/adoptions";
    }

    /**
     * Отображает форму для редактирования усыновления.
     *
     * @param id идентификатор усыновления
     * @param model объект Model для передачи данных в представление
     * @return имя шаблона формы редактирования усыновления
     */
    @GetMapping("/adoptions/edit/{id}")
    public String showEditAdoptionForm(@PathVariable Long id, Model model) {
        try {
            Adoption adoption = adoptionRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Усыновление не найдено"));

            model.addAttribute("adoption", adoption);
            model.addAttribute("animals", animalRepository.findAll());
            model.addAttribute("adopters", adopterRepository.findAll());

            return "adoptions-edit";
        } catch (Exception e) {
            return "redirect:/adoptions?error=" + e.getMessage();
        }
    }

    /**
     * Обновляет данные усыновления в базе данных.
     *
     * @param animalId идентификатор животного
     * @param adopterId идентификатор усыновителя
     * @return перенаправление на страницу списка усыновлений
     */
    @PostMapping("/adoptions/update")
    public String updateAdoption(@ModelAttribute Adoption adoption,
                                 @RequestParam Long animalId,
                                 @RequestParam Long adopterId) {
        try {
            Animal animal = animalRepository.findById(animalId)
                    .orElseThrow(() -> new RuntimeException("Животное не найдено"));
            Adopter adopter = adopterRepository.findById(adopterId)
                    .orElseThrow(() -> new RuntimeException("Усыновитель не найден"));

            adoption.setAnimal(animal);
            adoption.setAdopter(adopter);

            adoptionRepository.save(adoption);
            return "redirect:/adoptions";
        } catch (Exception e) {
            return "redirect:/adoptions?error=" + e.getMessage();
        }
    }

    /**
     * Тестовый метод для проверки состояния базы данных.
     * Отображает количество записей в каждой таблице.
     *
     * @return HTML страница с результатами теста
     */
    @GetMapping("/test-db")
    @ResponseBody
    public String testDatabase() {
        String result = "<h2>Тест базы данных</h2>";

        long animalCount = animalRepository.count();
        result += "<p>Животных: " + animalCount + "</p>";

        long adopterCount = adopterRepository.count();
        result += "<p>Усыновителей: " + adopterCount + "</p>";

        long procedureCount = medProcedureRepository.count();
        result += "<p>Процедур: " + procedureCount + "</p>";

        return result;
    }
}