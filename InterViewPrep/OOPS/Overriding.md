# Java Method Overriding - Payment Gateway System

## What is Method Overriding?

Method overriding is a feature in Java that allows a **child class to provide a specific implementation** of a method that is already defined in its parent class. It enables **runtime polymorphism** where the actual method called is determined by the object type at runtime, not the reference type.

## Real-World Example: E-Commerce Payment Gateway System

This project demonstrates method overriding through a practical e-commerce payment processing system that supports multiple payment gateways like Stripe, PayPal, and Razorpay.

## Class Structure

```
PaymentGateway (Abstract Parent Class)
├── StripeGateway (Child Class)
├── PayPalGateway (Child Class)
└── RazorpayGateway (Child Class)
```

## Key Methods Being Overridden

### 1. `processPayment(double amount, String currency)`
- **Stripe**: Uses payment intents and Stripe API
- **PayPal**: Redirects to PayPal login with buyer protection
- **Razorpay**: Supports UPI, cards, wallets with Indian compliance

### 2. `validateTransaction(String cardNumber, String cvv)`
- **Stripe**: Uses 3D Secure validation
- **PayPal**: Internal fraud detection system
- **Razorpay**: Indian banking regulation compliance

### 3. `processRefund(double amount, String transactionId)`
- **Stripe**: Instant refunds, 2-5 business days to bank
- **PayPal**: Instant to PayPal balance, 3-5 days to bank
- **Razorpay**: 5-7 working days as per RBI guidelines

## Method Overriding Rules Demonstrated

### ✅ Valid Overriding Examples

```java
// Parent class method
public abstract String processPayment(double amount, String currency);

// Child class override - SAME signature
@Override
public String processPayment(double amount, String currency) {
    // Stripe-specific implementation
    return "STRIPE_TXN_" + System.currentTimeMillis();
}
```

### ❌ Invalid Overriding Examples

```java
// Different parameter types - This is OVERLOADING, not OVERRIDING
@Override
public String processPayment(int amount, String currency) { } // ❌

// Different return type - Compilation Error
@Override
public boolean processPayment(double amount, String currency) { } // ❌

// Different method name - Not overriding
@Override
public String processPayments(double amount, String currency) { } // ❌
```

## Method Overriding Rules

1. **Same Method Signature**: Method name, parameters, and return type must be identical
2. **@Override Annotation**: Recommended for compile-time verification
3. **Access Modifiers**: Child class cannot reduce visibility (public → private ❌)
4. **Exception Handling**: Child class cannot throw broader checked exceptions
5. **Static Methods**: Cannot be overridden (they are hidden, not overridden)
6. **Final Methods**: Cannot be overridden
7. **Private Methods**: Cannot be overridden (not inherited)

## Runtime Polymorphism in Action

```java
// Same reference type, different object types
PaymentGateway[] gateways = {
    new StripeGateway("MERCHANT_123", "stripe_key"),    // Object type: StripeGateway
    new PayPalGateway("MERCHANT_123", "paypal_id"),     // Object type: PayPalGateway  
    new RazorpayGateway("MERCHANT_123", "razorpay_key") // Object type: RazorpayGateway
};

// Same method call, different implementations executed
for (PaymentGateway gateway : gateways) {
    gateway.processPayment(100.0, "$"); // Calls respective child class method
}
```

**Output:**
- First iteration: Stripe's `processPayment()` executes
- Second iteration: PayPal's `processPayment()` executes  
- Third iteration: Razorpay's `processPayment()` executes

## Key Benefits of Method Overriding

### 1. **Code Flexibility**
```java
// Easy to add new payment gateway without changing existing code
class ApplePayGateway extends PaymentGateway {
    @Override
    public String processPayment(double amount, String currency) {
        return "Apple Pay Touch ID processing...";
    }
}
```

### 2. **Maintainable Code**
- Each payment gateway's logic is encapsulated in its own class
- Changes to one gateway don't affect others
- Common functionality remains in parent class

### 3. **Real-World Scalability**
- Same interface for all payment methods
- Runtime decision making based on user preferences
- Easy integration with new payment providers

## Method Overriding vs Method Overloading

| Method Overriding | Method Overloading |
|-------------------|-------------------|
| **Same class hierarchy** (Parent-Child) | **Same class** |
| **Same method signature** | **Different method signature** |
| **Runtime polymorphism** | **Compile-time polymorphism** |
| **Different implementation** | **Different parameters** |
| **IS-A relationship** | **Same functionality, different inputs** |

## Example Usage

```java
// Create payment gateway based on user preference
public PaymentGateway createPaymentGateway(String type) {
    switch(type.toLowerCase()) {
        case "stripe": return new StripeGateway("MERCHANT_ID", "stripe_key");
        case "paypal": return new PayPalGateway("MERCHANT_ID", "paypal_id");
        case "razorpay": return new RazorpayGateway("MERCHANT_ID", "rzp_key");
        default: throw new IllegalArgumentException("Unsupported gateway: " + type);
    }
}

// Process payment - method overriding in action
PaymentGateway gateway = createPaymentGateway("stripe");
String result = gateway.processPayment(99.99, "$"); // Calls StripeGateway's implementation
```

## Real-World Applications

This pattern is used in:
- **E-commerce platforms** (Amazon, Flipkart, Shopify)
- **Banking systems** (multiple payment channels)
- **SaaS applications** (different subscription processors)
- **Mobile apps** (multiple payment options)

## Running the Example

1. Compile: `javac ECommercePaymentSystem.java`
2. Run: `java ECommercePaymentSystem`
3. Observe how same method calls produce different behaviors based on object type

## Summary

Method overriding enables **"same interface, different behavior"** - a powerful concept that makes Java applications flexible, maintainable, and scalable. The payment gateway example demonstrates how real-world systems leverage this feature to support multiple service providers through a unified interface.
