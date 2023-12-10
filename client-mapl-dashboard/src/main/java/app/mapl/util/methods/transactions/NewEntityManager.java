package app.mapl.util.methods.transactions;

import app.mapl.models.User;
import jakarta.persistence.*;
import org.springframework.boot.SpringApplication;
import org.springframework.util.Assert;

import java.util.Set;

public class NewEntityManager {

    public static void mainTrans(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("app.mapl.mapllistener");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            User user = new User();
            user.setUserId(1);
            user.setUsername("username");
            user.setPassword("password");
            user.setLastName("lastName");
            user.setFirstName("firstName");
            user.setUserType(1);
            user.setPhone("phone");
            user.setEmail("email");
            user.setCusUrl("cusUrl");
            user.setPhotoPath("photoPath");
            user.setIsActive(1);
            entityManager.persist(user);


//        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
            TypedQuery<User> userByEmail = entityManager.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);

            userByEmail.setParameter("email", "thomas1.maestas@gmail.com");
            User user2 = userByEmail.getSingleResult();
            System.out.println(user2);
            Assert.notNull(user2, "user2 is null");
            Assert.isTrue(user2.getEmail().equals("thomas1.maestas@gmail.com"), "thomas1.maestas@gmail.com is not email");
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }

    }
}