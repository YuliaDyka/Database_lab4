package com.api.view;

import com.api.controller.*;
import com.api.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MyView {
    @Autowired
    private FilmsController filmsController;
    @Autowired
    private ActorsController actorsController;
    @Autowired
    private  FilmActorsController filmActorsController;

    @Autowired
    private ReviewersController reviewersController;

    @Autowired
    private RaitingsController raitingsController;

    @Autowired
    private NewController newsController;
    @Autowired
    private CountryController countryController;

    @Autowired
    private Cash_collectionController cash_collectionController;

    @Autowired
    private BudgetController budgetController;

    @Autowired
    private NominationsController nominationsController;

    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private final Scanner input = new Scanner(System.in);

    private final Film nullFilm = new Film(null, null, null);

    private final Actor nullActor = new Actor(null, null, null);
    private final Reviewer nullReviewer = new Reviewer(null, null, null);
    private final Raiting nullRaiting = new Raiting(null, null, null);
    private final Country nullCountry = new Country( null, null);
    private final New nullNew = new New(null, null, null);
    private final Cash_collection nullCash_collection = new Cash_collection(null, null, null, null);

    private final Budget nullBudget = new Budget(null, null, null);

    private final Nomination nullNomination = new Nomination(null, null, null);


    public MyView() {
        menu = new LinkedHashMap<>();
        menu.put("A", "  A - Select all table");

        menu.put("0", "  0 - Table: Films");
        menu.put("01", "  01 - Create Film");
        menu.put("02", "  02 - Update Film");
        menu.put("03", "  03 - Delete from Film");
        menu.put("04", "  04 - Find all Films");
        menu.put("05", "  05 - Find Film by ID");
        menu.put("06", "  06 - Find Film by name");


        menu.put("1", "   1 - Table: Actors");
        menu.put("11", "  11 - Create Actor");
        menu.put("12", "  12 - Update Actor");
        menu.put("13", "  13 - Delete from Actor");
        menu.put("14", "  14 - Find all Actors");
        menu.put("15", "  15 - Find Actor by ID");
        menu.put("16", "  16 - Find Actor by name");


        menu.put("2", "   2 - Table: FilmActors");
        menu.put("21", "  21 - Create FilmActor");
        menu.put("22", "  22 - Update FilmActor");
        menu.put("23", "  23 - Delete from FilmActor");
        menu.put("24", "  24 - Find FilmActor by FilmId");
        menu.put("25", "  25 - Find FilmActor by ActorId");

        menu.put("3", "   3 - Table: Reviewers");
        menu.put("31", "  31 - Create Reviewer");
        menu.put("32", "  32 - Update Reviewer");
        menu.put("33", "  33 - Delete from Reviewer");
        menu.put("34", "  34 - Find all Reviewers");
        menu.put("35", "  35 - Find Reviewer by ID");
        menu.put("36", "  36 - Find Reviewer by film_id");

        menu.put("4", "   4 - Table: Raitings");
        menu.put("41", "  41 - Create Raiting");
        menu.put("42", "  42 - Update Raiting");
        menu.put("43", "  43 - Delete from Raiting");
        menu.put("44", "  44 - Find all Raitings");
        menu.put("45", "  45 - Find Raiting by ID");
        menu.put("46", "  46 - Find Raiting by film_id");

        menu.put("5", "   5 - Table: News");
        menu.put("51", "  51 - Create New");
        menu.put("52", "  52 - Update New");
        menu.put("53", "  53 - Delete from New");
        menu.put("54", "  54 - Find all News");
        menu.put("55", "  55 - Find New by ID");
        menu.put("56", "  56 - Find New by film_id");

        menu.put("6", "   6 - Table: Countries");
        menu.put("61", "  61 - Create Country");
        menu.put("62", "  62 - Update Country");
        menu.put("63", "  63 - Delete from Country");
        menu.put("64", "  64 - Find all Country");
        menu.put("65", "  65 - Find Country by ID");

        menu.put("7", "   7 - Table: Cash_collection");
        menu.put("71", "  71 - Create Cash_collection");
        menu.put("72", "  72 - Update Cash_collection");
        menu.put("73", "  73 - Delete from Cash_collection");
        menu.put("74", "  74 - Find all Cash_collection");
        menu.put("75", "  75 - Find Cash_collection by ID");
        menu.put("76", "  76 - Find Cash_collection by film_id");

        menu.put("8", "   8 - Table: Budget");
        menu.put("81", "  81 - Create Budget");
        menu.put("82", "  82 - Update Budget");
        menu.put("83", "  83 - Delete from Budget");
        menu.put("84", "  84 - Find all Budget");
        menu.put("85", "  85 - Find Budget by ID");
        menu.put("86", "  86 - Find Budget by film_id");

        menu.put("9", "   9 - Table: Nomination");
        menu.put("91", "  91 - Create Nomination");
        menu.put("92", "  92 - Update Nomination");
        menu.put("93", "  93 - Delete from Nomination");
        menu.put("94", "  94 - Find all Nominations");
        menu.put("95", "  95 - Find Nomination by ID");
        menu.put("96", "  96 - Find Nomination by film_id");



//        menu.put("3", "   3 - Table: Person");
//        menu.put("31", "  31 - Create Person");
//        menu.put("32", "  32 - Update Person");
//        menu.put("33", "  33 - Delete from Person");
//        menu.put("34", "  34 - Find all Persons");
//        menu.put("35", "  35 - Find Person by ID");
//        menu.put("36", "  36 - Find all Books by Person ID");
//        menu.put("37", "  37 - addBookByNameToPersonBySurname");

        menu.put("Q", "  Q - exit");

        methodsMenu = new LinkedHashMap<>();
        methodsMenu.put("A", this::selectAllTable);

        methodsMenu.put("01", this::createFilm);
        methodsMenu.put("02", this::updateFilm);
        methodsMenu.put("03", this::deleteFilm);
        methodsMenu.put("04", this::findAllFilms);
        methodsMenu.put("05", this::findFilmById);
        methodsMenu.put("06", this::findFilmByFilmName);


        methodsMenu.put("11", this::createActor);
        methodsMenu.put("12", this::updateActor);
        methodsMenu.put("13", this::deleteActor);
        methodsMenu.put("14", this::findAllActors);
        methodsMenu.put("15", this::findActorById);
        methodsMenu.put("16", this::findActorByName);

        methodsMenu.put("21", this::createFilmActors);
        methodsMenu.put("22", this::updateFilmActor);
        methodsMenu.put("23", this::deleteFilmActor);
        methodsMenu.put("24", this::findByFilmId);
        methodsMenu.put("25", this::findActorById);

        methodsMenu.put("31", this::createReviewers);
        methodsMenu.put("32", this::updateReviewers);
        methodsMenu.put("33", this::deleteFromReviewers);
        methodsMenu.put("34", this::findAllReviewers);
        methodsMenu.put("35", this::findReviewerById);
        methodsMenu.put("36", this::findReviewerByFilmId);

        methodsMenu.put("41", this::createRaitings);
        methodsMenu.put("42", this::updateRaitings);
        methodsMenu.put("43", this::deleteFromRaitings);
        methodsMenu.put("44", this::findAllRaitings);
        methodsMenu.put("45", this::findRaitingsById);
        methodsMenu.put("46", this::findRaitingsByFilmId);

        methodsMenu.put("51", this::createNews);
        methodsMenu.put("52", this::updateNews);
        methodsMenu.put("53", this::deleteFromNews);
        methodsMenu.put("54", this::findAllNews);
        methodsMenu.put("55", this::findNewsById);
        methodsMenu.put("56", this::findNewsByFilmId);

        methodsMenu.put("61", this::createCountry);
        methodsMenu.put("62", this::updateCountry);
        methodsMenu.put("63", this::deleteFromCountry);
        methodsMenu.put("64", this::findAllCountry);
        methodsMenu.put("65", this::findCountryById);

        methodsMenu.put("71", this::createCash_collection);
        methodsMenu.put("72", this::updateCash_collection);
        methodsMenu.put("73", this::deleteFromCash_collection);
        methodsMenu.put("74", this::findAllCash_collection);
        methodsMenu.put("75", this::findCash_collectionById);
        methodsMenu.put("76", this::findCash_collectionByFilmId);

        methodsMenu.put("81", this::createBudget);
        methodsMenu.put("82", this::updateBudget);
        methodsMenu.put("83", this::deleteFromBudget);
        methodsMenu.put("84", this::findAllBudget);
        methodsMenu.put("85", this::findBudgetById);
        methodsMenu.put("86", this::findBudgetByFilmId);

        methodsMenu.put("91", this::createNomination);
        methodsMenu.put("92", this::updateNomination);
        methodsMenu.put("93", this::deleteFromNomination);
        methodsMenu.put("94", this::findAllNominations);
        methodsMenu.put("95", this::findNominationById);
        methodsMenu.put("96", this::findNominationByFilmId);


//        methodsMenu.put("21", this::createCity);
//        methodsMenu.put("22", this::updateCity);
//        methodsMenu.put("23", this::deleteFromCity);
//        methodsMenu.put("24", this::findAllCities);
//        methodsMenu.put("25", this::findCityById);
//
//        methodsMenu.put("31", this::createPerson);
//        methodsMenu.put("32", this::updatePerson);
//        methodsMenu.put("33", this::deleteFromPerson);
//        methodsMenu.put("34", this::findAllPersons);
//        methodsMenu.put("35", this::findPersonById);
//        methodsMenu.put("36", this::findAllBooksById);
//        methodsMenu.put("37", this::addBookByNameToPersonBySurname);
    }

    private void selectAllTable() {
        findAllFilms();
        findAllActors();
        findAllReviewers();
        findAllRaitings();
        findAllNews();
        findAllCash_collection();
//        findAllBooks();
//        findAllCities();
//        findAllPersons();
    }

    // region FILM ---------------------------------------------------

    private void createFilm() {
        System.out.println("Input 'film_name': ");
        String filmName = input.nextLine();
        System.out.println("Input 'date'(2008-07-18): ");
        String date = input.nextLine();
        Film film = new Film(null, filmName, date);

        int count = filmsController.create(film);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateFilm() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'film_name': ");
        String filmName = input.nextLine();

        System.out.println("Input new 'date'(2008-07-18): ");
        String  date = input.nextLine();
        Film film = new Film(null, filmName, date);

        int count = filmsController.update(id, film);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFilm() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = filmsController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllFilms() {
        System.out.println("\nTable: FILM");
        List<Film> films = filmsController.findAll();
        for (Film film  : films) {
            System.out.println(film);

            List<Filmactor> filmActors = filmActorsController.findByFilmId(film.getId());
            int i = 1;

            System.out.println(" ---- Actors ----------- ");
            for (Filmactor fa: filmActors) {
                Optional<Actor> findActor = actorsController.findById(fa.getActor_id());
                String name = findActor.map(Actor::getFull_name).orElse(null);
                System.out.println( i+ ". - "+ name);
                i++;
            }

        }


    }

    private void findFilmById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Film> film = filmsController.findById(id);
        System.out.println(film.orElse(nullFilm));
    }

    private void findFilmByFilmName() {
        System.out.println("Input 'film_name': ");
        String filmName = input.nextLine();

        Optional<Film> film = filmsController.findByName(filmName);
        System.out.println(film.orElse(nullFilm));
    }


    // region Actor ---------------------------------------------------
    private void createActor() {
        System.out.println("Input 'full name': ");
        String actorName = input.nextLine();
        System.out.println("Input 'age': ");
        Integer age = Integer.valueOf((input.nextLine()));

        System.out.println("Input 'film_id': ");
        Integer film_id = Integer.valueOf((input.nextLine()));

        Actor actor = new Actor(null, actorName, age);

        int count = actorsController.create(actor);
        Optional<Actor> actorOptional = actorsController.findByName(actorName);

        int actor_id = actorOptional.map(Actor::getId).orElse(null);
        Filmactor filmActor = new Filmactor(null, actor_id, film_id);

        int c = filmActorsController.create(filmActor);

        System.out.printf("There are created %d rows\n", count);
    }

    private void updateActor() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'name': ");
        String name = input.nextLine();
        System.out.println("Input new 'age': ");
        Integer age = Integer.valueOf((input.nextLine()));
        Actor actor = new Actor(null, name, age);

        int count = actorsController.update(id, actor);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteActor() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        List<Filmactor> filmactors = filmActorsController.findByActorId(id);
        int countFilmActors = 0;
        for (Filmactor filmactor  : filmactors) {

           int amount = filmActorsController.delete(id);
           countFilmActors += amount;
        }
        int count = actorsController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
        System.out.printf("There are deleted %d rows in film actors\n", countFilmActors);
    }

    private void findAllActors() {
        System.out.println("\nTable: ACTORS");
        List<Actor> actors = actorsController.findAll();


        for (Actor actor : actors) {
            System.out.println("");
            List<Filmactor> filmActors = filmActorsController.findByActorId(actor.getId());

            System.out.println(actor);
            int i = 1;

            System.out.println(" ---- Films ----------- ");
            for (Filmactor fa: filmActors) {
                Optional<Film> film = filmsController.findById(fa.getFilm_id());
                String name = film.map(Film::getName).orElse(null);
                System.out.println( i+ ". - "+ name);
                i++;
            }
        }
    }

    private void findActorById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Actor> actor = actorsController.findById(id);
        System.out.println(actor.orElse(nullActor));
        List<Filmactor> filmActors = filmActorsController.findByActorId(id);

        int i = 1;

        System.out.println(" ---- Films ----------- ");
        for (Filmactor fa: filmActors) {
            Optional<Film> film = filmsController.findById(fa.getFilm_id());
            String name = film.map(Film::getName).orElse(null);
            System.out.println( i+ ". - "+ name);
            i++;
        }
    }

    private void findActorByName() {
        System.out.println("Input 'name': ");
        String name = input.nextLine();

        Optional<Actor> actor = actorsController.findByName(name);
        System.out.println(actor.orElse(nullActor));
    }

    // region FilmActors --------------------------------------------
    // region Actor ---------------------------------------------------
    private void createFilmActors() {
        System.out.println("Input 'film_id': ");
        Integer film_id = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'actor_id': ");
        Integer actor_id = Integer.valueOf((input.nextLine()));

        Filmactor filmActor = new Filmactor(null, film_id, actor_id);

        int count = filmActorsController.create(filmActor);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateFilmActor() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'film_id': ");
        Integer film_id = Integer.valueOf((input.nextLine()));
        System.out.println("Input new 'actor_id': ");
        Integer actor_id = Integer.valueOf((input.nextLine()));
        Filmactor filmActor = new Filmactor(null, film_id, actor_id);

        int count = filmActorsController.update(id, filmActor);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFilmActor() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = filmActorsController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private  void findByFilmId() {
        System.out.println("Input 'film_id': ");
        Integer film_id = Integer.valueOf((input.nextLine()));

        List<Filmactor> filmactors = filmActorsController.findByFilmId(film_id);
        for (Filmactor filmactor : filmactors) {
            System.out.println(filmactor);
        }
    }

    private  void findByActorId() {
        System.out.println("Input 'actor_id': ");
        Integer actor_id = Integer.valueOf((input.nextLine()));

        List<Filmactor> filmactors = filmActorsController.findByActorId(actor_id);
        for (Filmactor filmactor : filmactors) {
            System.out.println(filmactor);
        }
    }

    // region Reviewers ---------------------------------------------------
    private void createReviewers() {
        System.out.println("Input 'film_id': ");
        Integer film_id = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'info': ");
        String info = input.nextLine();

        Reviewer reviewer = new Reviewer(null, info, film_id);

        int count =reviewersController.create(reviewer);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateReviewers() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'info': ");
        String info = input.nextLine();

        System.out.println("Input 'film_id': ");
        Integer film_id = Integer.valueOf((input.nextLine()));


        Reviewer reviewer = new Reviewer(null, info, film_id);

        int count = reviewersController.update(id, reviewer);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromReviewers() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = reviewersController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }
    private void findAllReviewers() {
        System.out.println("\nTable: REVIEWERS");
        List<Reviewer> reviewers = reviewersController.findAll();
        for (Reviewer reviewer  : reviewers) {
            System.out.println(reviewer);
        }
    }

    private  void findReviewerById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Reviewer> reviewer = reviewersController.findById(id);

        System.out.println(reviewer.orElse(nullReviewer));

    }

    private void findReviewerByFilmId() {
        System.out.println("Input 'film_id': ");
        Integer film_id = Integer.valueOf(input.nextLine());

        List<Reviewer> reviewers = reviewersController.FindByFilmId(film_id);
        for(Reviewer reviewer : reviewers){
            System.out.println(reviewer);
        }
    }

    // region Raiting ---------------------------------------------------

    private void createRaitings() {
        System.out.println("Input 'raiting': ");
        Integer input_raiting = Integer.valueOf((input.nextLine()));
        System.out.println("Input 'film_id': ");
        Integer film_id = Integer.valueOf(input.nextLine());

        Raiting raiting = new Raiting(null, input_raiting, film_id);

        int count =raitingsController.create(raiting);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateRaitings() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'raiting': ");
        Integer input_raiting = Integer.valueOf(input.nextLine());

        System.out.println("Input 'film_id': ");
        Integer film_id = Integer.valueOf((input.nextLine()));


        Raiting raiting = new Raiting(null, input_raiting, film_id);

        int count = raitingsController.update(id, raiting);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromRaitings() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = raitingsController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllRaitings() {
        System.out.println("\nTable: RAITINGS");
        List<Raiting> raitings = raitingsController.findAll();
        for (Raiting raiting  : raitings) {
            System.out.println(raiting);
        }
    }

    private  void findRaitingsById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Raiting> raiting = raitingsController.findById(id);

        System.out.println(raiting.orElse(nullRaiting));

    }

    private void findRaitingsByFilmId() {
        System.out.println("Input 'film_id': ");
        Integer film_id = Integer.valueOf(input.nextLine());

        List<Raiting> raitings = raitingsController.FindByFilmId(film_id);
        for(Raiting raiting : raitings){
            System.out.println(raiting);
        }
    }

    // region NEWS ---------------------------------------------------
    private void createNews() {
        System.out.println("Input 'new': ");
        String input_new = input.nextLine();
        System.out.println("Input 'film_id': ");
        Integer film_id = Integer.valueOf(input.nextLine());

        New createNew = new New(null, input_new, film_id);

        int count =newsController.create(createNew);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateNews() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        System.out.println("Input new 'new': ");
        String input_new = input.nextLine();

        System.out.println("Input 'film_id': ");
        Integer film_id = Integer.valueOf((input.nextLine()));


        New updateNew = new New(null, input_new, film_id);

        int count = newsController.update(id, updateNew);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromNews() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = newsController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllNews() {
        System.out.println("\nTable: News");
        List<New> news = newsController.findAll();
        for (New n  : news) {
            System.out.println(n);
        }
    }

    private  void findNewsById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<New> n = newsController.findById(id);

        System.out.println(n.orElse(nullNew));

    }

    private void findNewsByFilmId() {
        System.out.println("Input 'film_id': ");
        Integer film_id = Integer.valueOf(input.nextLine());

        List<New> news = newsController.FindByFilmId(film_id);
        for(New n : news){
            System.out.println(n);
        }
    }




    //endregion
    // region Country ---------------------------------------------------
    private void createCountry() {
        System.out.println("Input 'name': ");
        String name = input.nextLine();

        Country country = new Country(null, name);

        int count = countryController.create(country);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateCountry() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.println("Input new 'name': ");
        String name = input.nextLine();

        Country country = new Country(null, name);

        int count = countryController.update(id, country);
        System.out.printf("There are updated %d rows\n", count);
    }

    private void deleteFromCountry() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(input.nextLine());

        int count = countryController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void findAllCountry() {
        System.out.println("\nTable: COUNTRY");
        List<Country> countries = countryController.findAll();
        for (Country c : countries) {
            System.out.println(c);
        }
    }

    private void findCountryById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(input.nextLine());

        Optional<Country> c = countryController.findById(id);
        System.out.println(c.orElse(nullCountry));
    }

    // region Cash_collection ---------------------------------------------------
    private void createCash_collection() {
        System.out.println("Input 'price': ");
        Integer price = Integer.valueOf(input.nextLine());
        System.out.println("Input 'film_id': ");
        Integer film_id = Integer.valueOf(input.nextLine());
        System.out.println("Input 'country_id': ");
        Integer country_id = Integer.valueOf(input.nextLine());

        Cash_collection cash_collection = new Cash_collection(null, price, film_id, country_id);

        int count = cash_collectionController.create(cash_collection);
        System.out.printf("There are created %d rows\n", count);
    }

    private void updateCash_collection() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.println("Input 'price': ");
        Integer price = Integer.valueOf(input.nextLine());
        System.out.println("Input 'film_id': ");
        Integer film_id = Integer.valueOf(input.nextLine());
        System.out.println("Input 'country_id': ");
        Integer country_id = Integer.valueOf(input.nextLine());

        Cash_collection cash_collection = new Cash_collection(null, price, film_id, country_id);

        int count = cash_collectionController.update(id, cash_collection);
        System.out.printf("There are created %d rows\n", count);
    }

    private void deleteFromCash_collection() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        int count = cash_collectionController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void  findAllCash_collection() {
        System.out.println("\nTable: Cash_collection");
        List<Cash_collection> cash_collections = cash_collectionController.findAll();
        for(Cash_collection cash_collection: cash_collections) {
            System.out.println(cash_collection);
        }
    }

    private void findCash_collectionById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Cash_collection> cash_collection = cash_collectionController.findById(id);
        System.out.println(cash_collection.orElse(nullCash_collection));
    }

    private void findCash_collectionByFilmId() {
        System.out.println("Input 'film_id': ");
        Integer film_id = Integer.valueOf(input.nextLine());

        List<Cash_collection> cash_collections = cash_collectionController.FindByFilmId(film_id);
        for(Cash_collection cash_collection : cash_collections){
            System.out.println(cash_collection);
        }
    }

    // region Budget ---------------------------------------------------

    private  void createBudget() {
        System.out.println("Input 'price': ");
        Integer price = Integer.valueOf(input.nextLine());
        System.out.println("Input 'film_id': ");
        Integer film_id = Integer.valueOf(input.nextLine());


        Budget budget = new Budget(null, price, film_id);

        int count = budgetController.create(budget);
        System.out.printf("There are created %d rows\n", count);

    }

    private void updateBudget() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.println("Input 'price': ");
        Integer price = Integer.valueOf(input.nextLine());
        System.out.println("Input 'film_id': ");
        Integer film_id = Integer.valueOf(input.nextLine());

        Budget budget = new Budget(null, price, film_id);

        int count = budgetController.update(id, budget);
        System.out.printf("There are created %d rows\n", count);
    }

    private void deleteFromBudget() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(input.nextLine());

        int count = budgetController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void  findAllBudget() {
        System.out.println("\nTable: Budget");
        List<Budget> budgets = budgetController.findAll();
        for(Budget budget: budgets) {
            System.out.println(budget);
        }
    }

    private  void findBudgetById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Budget> budget = budgetController.findById(id);

        System.out.println(budget.orElse(nullBudget));

    }


    private void findBudgetByFilmId() {
        System.out.println("Input 'film_id': ");
        Integer film_id = Integer.valueOf(input.nextLine());

        List<Budget> budgets = budgetController.FindByFilmId(film_id);
        for(Budget budget : budgets){
            System.out.println(budget);
        }
    }

    // region Nominations ---------------------------------------------------

    private  void createNomination() {
        System.out.println("Input 'nomination': ");
        String input_nomination = input.nextLine();
        System.out.println("Input 'film_id': ");
        Integer film_id = Integer.valueOf(input.nextLine());


        Nomination nomination = new Nomination(null, input_nomination, film_id);

        int count = nominationsController.create(nomination);
        System.out.printf("There are created %d rows\n", count);

    }

    private void updateNomination() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(input.nextLine());
        System.out.println("Input 'nomination': ");
        String input_nomination = input.nextLine();
        System.out.println("Input 'film_id': ");
        Integer film_id = Integer.valueOf(input.nextLine());

        Nomination nomination = new Nomination(null, input_nomination, film_id);

        int count = nominationsController.update(id, nomination);
        System.out.printf("There are created %d rows\n", count);
    }

    private void deleteFromNomination() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf(input.nextLine());

        int count = nominationsController.delete(id);
        System.out.printf("There are deleted %d rows\n", count);
    }

    private void  findAllNominations() {
        System.out.println("\nTable: Nominations");
        List<Nomination> nominations = nominationsController.findAll();
        for(Nomination nomination: nominations) {
            System.out.println(nomination);
        }
    }

    private void findNominationById() {
        System.out.println("Input 'id': ");
        Integer id = Integer.valueOf((input.nextLine()));

        Optional<Nomination> nomination = nominationsController.findById(id);

        System.out.println(nomination.orElse(nullNomination));
    }

    private void findNominationByFilmId() {
        System.out.println("Input 'film_id': ");
        Integer film_id = Integer.valueOf(input.nextLine());

        List<Nomination> nominations = nominationsController.FindByFilmId(film_id);
        for(Nomination nomination : nominations){
            System.out.println(nomination);
        }
    }

//    // endregion
//    // region PERSON -------------------------------------------------
//    private void createPerson() {
//        System.out.println("Input 'surname': ");
//        String surname = input.nextLine();
//        System.out.println("Input 'name': ");
//        String name = input.nextLine();
//        System.out.println("Input 'city': ");
//        String city = input.nextLine();
//        System.out.println("Input 'email': ");
//        String email = input.nextLine();
//
//        Person person = new Person(null, surname, name, city, email);
//
//        int count = personController.create(person);
//        System.out.printf("There are created %d rows\n", count);
//    }
//
//    private void updatePerson() {
//        System.out.println("Input 'id': ");
//        Integer id = Integer.valueOf((input.nextLine()));
//
//        System.out.println("Input new 'surname': ");
//        String surname = input.nextLine();
//        System.out.println("Input new 'name': ");
//        String name = input.nextLine();
//        System.out.println("Input new 'city': ");
//        String city = input.nextLine();
//        System.out.println("Input new 'email': ");
//        String email = input.nextLine();
//
//        Person person = new Person(null, surname, name, city, email);
//
//        int count = personController.update(id, person);
//        System.out.printf("There are updated %d rows\n", count);
//    }
//
//    private void deleteFromPerson() {
//        System.out.println("Input 'id': ");
//        Integer id = Integer.valueOf((input.nextLine()));
//
//        int count = personController.delete(id);
//        System.out.printf("There are deleted %d rows\n", count);
//    }
//
//    private void findAllPersons() {
//        System.out.println("\nTable: PERSON");
//        List<Person> people = personController.findAll();
//        for (Person person : people) {
//            System.out.println(person);
//        }
//    }
//
//    private void findPersonById() {
//        System.out.println("Input 'id': ");
//        Integer id = Integer.valueOf((input.nextLine()));
//
//        Optional<Person> person = personController.findById(id);
//        System.out.println(person.orElse(nullPerson));
//    }
//
//    private void findAllBooksById() {
//        System.out.println("Input 'person id': ");
//        Integer id = Integer.valueOf((input.nextLine()));
//
//        List<Book> books = personController.findAllBooksBy(id);
//        for (Book book : books) {
//            System.out.println(book);
//        }
//    }
//
//    private void addBookByNameToPersonBySurname() {
//        System.out.println("Input 'person surname': ");
//        String surname = input.nextLine();
//        System.out.println("Input 'book name': ");
//        String bookName = input.nextLine();
//
//        String msg = personController.addBookByNameToPersonBySurname(bookName, surname);
//        System.out.println(msg);
//    }
    //endregion

    //-------------------------------------------------------------------------
    // region output
    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String key : menu.keySet())
            if (key.length() == 1) System.out.println(menu.get(key));
    }

    private void outputSubMenu(String fig) {

        System.out.println("\nSubMENU:");
        for (String key : menu.keySet())
            if (key.length() != 1 && key.substring(0, 1).equals(fig)) System.out.println(menu.get(key));
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();

            if (keyMenu.matches("^\\d")) {
                outputSubMenu(keyMenu);
                System.out.println("Please, select menu point.");
                keyMenu = input.nextLine().toUpperCase();
            }

            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (!keyMenu.equals("Q"));
    }

    //endregion
}

