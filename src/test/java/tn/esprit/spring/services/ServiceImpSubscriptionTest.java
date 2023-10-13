package tn.esprit.spring.services;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.spring.controllers.SubscriptionRestController;
import tn.esprit.spring.entities.Subscription;
import tn.esprit.spring.entities.TypeSubscription;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

@ExtendWith(MockitoExtension.class)
public class ServiceImpSubscriptionTest {






        @Mock
        private ISubscriptionServices subscriptionServices;

        @InjectMocks
        private SubscriptionRestController subscriptionController;

        @Test
        public void testAddSubscription() {
            Subscription subscription = new Subscription();
            subscription.setNumSub(1L);
            subscription.setStartDate(LocalDate.of(2023, 10, 1));
            subscription.setEndDate(LocalDate.of(2024, 10, 1));
            subscription.setPrice(100.0f);
            subscription.setTypeSub(TypeSubscription.ANNUAL);

            when(subscriptionServices.addSubscription(any(Subscription.class))).thenReturn(subscription);

            Subscription result = subscriptionController.addSubscription(subscription);

            assertEquals(subscription, result);
        }

        @Test
        public void testGetById() {
            Long subscriptionId = 1L;
            Subscription subscription = new Subscription();
            subscription.setNumSub(subscriptionId);
            subscription.setStartDate(LocalDate.of(2023, 10, 1));
            subscription.setEndDate(LocalDate.of(2024, 10, 1));
            subscription.setPrice(100.0f);
            subscription.setTypeSub(TypeSubscription.ANNUAL);

            when(subscriptionServices.retrieveSubscriptionById(subscriptionId)).thenReturn(subscription);

            Subscription result = subscriptionController.getById(subscriptionId);

            assertEquals(subscription, result);
        }


        @Test
        public void testUpdateSubscription() {
            Subscription subscription = new Subscription();
            subscription.setNumSub(1L);
            subscription.setStartDate(LocalDate.of(2023, 10, 1));
            subscription.setEndDate(LocalDate.of(2024, 10, 1));
            subscription.setPrice(100.0f);
            subscription.setTypeSub(TypeSubscription.ANNUAL);

            when(subscriptionServices.updateSubscription(any(Subscription.class))).thenReturn(subscription);

            Subscription result = subscriptionController.updateSubscription(subscription);

            assertEquals(subscription, result);
        }

        @Test
        public void testGetSubscriptionsByDates() {
            LocalDate startDate = LocalDate.of(2023, 10, 1);
            LocalDate endDate = LocalDate.of(2023, 12, 31);

            List<Subscription> subscriptions = new ArrayList<>();
            subscriptions.add(new Subscription(1L, LocalDate.of(2023, 10, 1), LocalDate.of(2024, 10, 1), 100.0f, TypeSubscription.ANNUAL));
            subscriptions.add(new Subscription(2L, LocalDate.of(2023, 11, 1), LocalDate.of(2024, 11, 1), 120.0f, TypeSubscription.ANNUAL));

            when(subscriptionServices.retrieveSubscriptionsByDates(startDate, endDate)).thenReturn(subscriptions);

            List<Subscription> result = subscriptionController.getSubscriptionsByDates(startDate, endDate);

            assertEquals(subscriptions, result);
        }
    }



