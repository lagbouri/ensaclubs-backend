package me.oussa.ensaclubs;

import me.oussa.ensaclubs.dto.ClubDto;
import me.oussa.ensaclubs.dto.EventDto;
import me.oussa.ensaclubs.dto.StudentDto;
import me.oussa.ensaclubs.dto.TeacherDto;
import me.oussa.ensaclubs.exceptions.ClubNotFoundException;
import me.oussa.ensaclubs.exceptions.StudentAlreadyExistsException;
import me.oussa.ensaclubs.exceptions.StudentNotFoundException;
import me.oussa.ensaclubs.exceptions.TeacherAlreadyExistsException;
import me.oussa.ensaclubs.service.ClubService;
import me.oussa.ensaclubs.service.EventService;
import me.oussa.ensaclubs.service.StudentService;
import me.oussa.ensaclubs.service.TeacherService;

import java.util.Date;

// @Component
public class DatabaseInitializer {
    private final StudentService studentService;
    private final TeacherService teacherService;
    private final ClubService clubService;
    private final EventService eventService;

    public DatabaseInitializer(StudentService studentService, TeacherService teacherService, ClubService clubService, EventService eventService) throws ClubNotFoundException, StudentNotFoundException {

        this.studentService = studentService;
        this.teacherService = teacherService;
        this.clubService = clubService;
        this.eventService = eventService;

        // initDatabase();

        // join student to club
        clubService.joinClub(1, 1);
    }

    // init database
    private void initDatabase() throws StudentAlreadyExistsException, TeacherAlreadyExistsException, ClubNotFoundException, StudentNotFoundException {
        // Add student
        StudentDto student = new StudentDto();
        student.setApogee(123456);
        student.setFirstName("Oussama");
        student.setLastName("Regasse");
        student.setEmail("oussama@regasse");
        student.setPhone("0666666666");
        student.setFiliere("GTR");
        studentService.addStudent(student);

        // Add teacher
        TeacherDto teacher = new TeacherDto();
        teacher.setCin("A12345");
        teacher.setFirstName("Mr");
        teacher.setLastName("Ostad");
        teacher.setEmail("mr@ostad");
        teacher.setPhone("0666666666");
        teacher.setDepartment("Informatique");
        teacherService.addTeacher(teacher);

        // Add club
        ClubDto club = new ClubDto();
        club.setName("ENIAC Club");
        club.setDescription("ENIAC club est un club de l'Ecole Nationale des Sciences Appliquées de SAFI qui vise à améliorer le savoir des étudiants , débutants ou professionnels , dans le domaine d'informatique et des nouvelles technologies.");
        club.setCategory("Informatique");
        club.setImage("https://www.eniacclub.yj.lu/wp-content/uploads/2022/08/245509536_111793047946677_7555609402602487882_n-removebg-preview.png");
        club.setCreatorId(1);
        club.setActivated(true);
        club.setUpdatedAt(new Date());
        club.setCreatedAt(new Date());
        clubService.addClub(club);

        // add event to club
        EventDto event = new EventDto();
        event.setClubId(1);
        event.setTitle("Poblem solving competition");
        event.setDetails("ENIAC Club organized an advanced programming competition intended to support the talents of students in computer science field.");
        event.setImage("https://www.eniacclub.yj.lu/wp-content/uploads/2022/08/262354675_129591299500185_1114327128340276160_n.jpg");
        event.setDate(new Date());
        eventService.addEvent(event);
    }

}