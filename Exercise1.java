Exercise 1:
Behavioral Design Patterns in Java

1.Payment Processing System
In this use case, let's say we have a system where users can pay using different methods like 
Credit Card, PayPal, or Google Pay. Each payment method will have its own strategy to 
process the payment.
public interface PaymentStrategy {
 void pay(int amount);
}
public class CreditCardPayment implements PaymentStrategy {
 @Override
 public void pay(int amount) {
 System.out.println("Paid " + amount + " using Credit Card.");
 }
}
public class PayPalPayment implements PaymentStrategy {
 @Override
 public void pay(int amount) {
 System.out.println("Paid " + amount + " using PayPal.");
 }
}
public class GooglePayPayment implements PaymentStrategy {
 @Override
 public void pay(int amount) {
 System.out.println("Paid " + amount + " using Google Pay.");
 }
}
public class PaymentContext {
 private PaymentStrategy paymentStrategy;
 public PaymentContext(PaymentStrategy paymentStrategy) {
 this.paymentStrategy = paymentStrategy;
 }
 public void executePayment(int amount) {
 paymentStrategy.pay(amount);
 }
}
public class Main {
 public static void main(String[] args) {
 PaymentContext context;
 // Pay using Credit Card
 context = new PaymentContext(new CreditCardPayment());
 context.executePayment(100);
 // Pay using PayPal
 context = new PaymentContext(new PayPalPayment());
 context.executePayment(200);
 // Pay using Google Pay
 context = new PaymentContext(new GooglePayPayment());
 context.executePayment(300);
 }
}
Output:
Paid 100 using Credit Card.
Paid 200 using PayPal.
Paid 300 using Google Pay.


2. News Subscription System
In this use case, we'll create a News Subscription System where users can subscribe to 
different news channels and get notified when a new article is published.
public interface Observer {
 void update(String news);
}
public interface Subject {
 void subscribe(Observer observer);
 void unsubscribe(Observer observer);
 void notifyObservers();
}
import java.util.ArrayList;
import java.util.List;
public class NewsChannel implements Subject {
 private List<Observer> subscribers = new ArrayList<>();
 private String latestNews;
 public void setLatestNews(String news) {
 this.latestNews = news;
 notifyObservers();
 }
 @Override
 public void subscribe(Observer observer) {
 subscribers.add(observer);
 }
 @Override
 public void unsubscribe(Observer observer) {
 subscribers.remove(observer);
 }
 @Override
 public void notifyObservers() {
 for (Observer subscriber : subscribers) {
 subscriber.update(latestNews);
 }
 }
}
public class Subscriber implements Observer {
 private String name;
 public Subscriber(String name) {
 this.name = name;
 }
 @Override
 public void update(String news) {
 System.out.println(name + " received news update: " + news);
 }
}
public class Main {
 public static void main(String[] args) {
 NewsChannel newsChannel = new NewsChannel();
 // Create subscribers
 Subscriber subscriber1 = new Subscriber("Alice");
 Subscriber subscriber2 = new Subscriber("Bob");
 Subscriber subscriber3 = new Subscriber("Charlie");
 // Subscribe to the news channel
 newsChannel.subscribe(subscriber1);
 newsChannel.subscribe(subscriber2);
 // Publish a new article
 newsChannel.setLatestNews("Breaking News: Java Observer Pattern Simplified!");
 // Bob unsubscribes
 newsChannel.unsubscribe(subscriber2);
 // Publish another article
 newsChannel.setLatestNews("Latest Update: Observer Pattern in Action!");
 // Charlie subscribes
 newsChannel.subscribe(subscriber3);
 // Publish yet another article
 newsChannel.setLatestNews("News Flash: New Observer Joined the Channel!");
 }
}
Output:
Alice received news update: Breaking News: Java Observer Pattern Simplified!
Bob received news update: Breaking News: Java Observer Pattern Simplified!
Alice received news update: Latest Update: Observer Pattern in Action!
Alice received news update: News Flash: New Observer Joined the Channel!
Charlie received news update: News Flash: New Observer Joined the Channel!



2. Creational design pattern 
1. Factory Method Pattern - Animal Factory Example
• Use Case: You need to create different types of animals (e.g., Dog, Cat, Rabbit), but 
want to avoid directly instantiating these objects throughout the code. You also want 
the exact type of animal to be determined at runtime based on user input.
• Solution: Use the Factory Method to create an AnimalFactory that returns the 
appropriate animal instance (Dog, Cat, Rabbit) based on the input. This encapsulates 
the object creation logic and allows you to extend the code easily by adding more 
animal types in the future.
public class AnimalFactory {
 public Animal getAnimal(String animalType) {
 if (animalType.equalsIgnoreCase("dog")) return new Dog();
 if (animalType.equalsIgnoreCase("cat")) return new Cat();
 if (animalType.equalsIgnoreCase("rabbit")) return new Rabbit();
 return null;
 }
}


2. Builder Pattern - Computer Configuration Example
• Use Case: You are building a system that configures computers with multiple 
customizable components (e.g., CPU, GPU, RAM). Instead of using a long 
constructor with many parameters, you want to build the computer in steps with 
flexibility in the order of options.
• Solution: Use the Builder Pattern to construct a Computer class step by step. The 
builder allows users to add or skip certain parts and prevents the need for a large 
Computer myComputer = new Computer.Builder()
 .withCPU("Intel i7")
 .withRAM(16)
 .withGPU("Nvidia GTX 1080")
 .withStorage("1TB SSD")
 .build();
These patterns improve code organization, readability, and scalability
