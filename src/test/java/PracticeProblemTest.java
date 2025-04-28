import java.lang.reflect.*;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class PracticeProblemTest {

     @Test
    public void testCowClassExists() {
        try {
            Class.forName("Cow");
            assertTrue(true);
        } catch (ClassNotFoundException e) {
            fail("Cow class does not exist");
        }
    }
    
    @Test
    public void testCowConstructor() {
        try {
            Class<?> cowClass = Class.forName("Cow");
            Constructor<?> constructor = cowClass.getConstructor(String.class, int.class, double.class);
            assertNotNull(constructor, "Constructor with (String, int, double) parameters should exist");
        } catch (ClassNotFoundException e) {
            fail("Cow class does not exist");
        } catch (NoSuchMethodException e) {
            fail("Cow constructor with (String, int, double) parameters does not exist");
        }
    }
    
    @Test
    public void testGetNameMethod() {
        try {
            Class<?> cowClass = Class.forName("Cow");
            Method getNameMethod = cowClass.getMethod("getName");
            assertEquals(String.class, getNameMethod.getReturnType(), 
                    "getName() should return String");
        } catch (ClassNotFoundException e) {
            fail("Cow class does not exist");
        } catch (NoSuchMethodException e) {
            fail("getName() method does not exist in Cow class");
        }
    }
    
    @Test
    public void testGetAgeMethod() {
        try {
            Class<?> cowClass = Class.forName("Cow");
            Method getAgeMethod = cowClass.getMethod("getAge");
            assertEquals(int.class, getAgeMethod.getReturnType(), 
                    "getAge() should return int");
        } catch (ClassNotFoundException e) {
            fail("Cow class does not exist");
        } catch (NoSuchMethodException e) {
            fail("getAge() method does not exist in Cow class");
        }
    }
    
    @Test
    public void testGetWeightMethod() {
        try {
            Class<?> cowClass = Class.forName("Cow");
            Method getWeightMethod = cowClass.getMethod("getWeight");
            assertEquals(double.class, getWeightMethod.getReturnType(), 
                    "getWeight() should return double");
        } catch (ClassNotFoundException e) {
            fail("Cow class does not exist");
        } catch (NoSuchMethodException e) {
            fail("getWeight() method does not exist in Cow class");
        }
    }
    
    @Test
    public void testToStringMethod() {
        try {
            Class<?> cowClass = Class.forName("Cow");
            Method toStringMethod = cowClass.getMethod("toString");
            assertEquals(String.class, toStringMethod.getReturnType(), 
                    "toString() should return String");
            
            // Create a cow instance if the class exists
            Constructor<?> constructor = cowClass.getConstructor(String.class, int.class, double.class);
            Object cow = constructor.newInstance("Daisy", 3, 950.75);
            
            String result = (String) toStringMethod.invoke(cow);
            assertEquals("Daisy, 3 - 950.75", result, 
                    "toString() should return name, age, and weight in the specified format");
        } catch (ClassNotFoundException e) {
            fail("Cow class does not exist");
        } catch (NoSuchMethodException e) {
            fail("toString() method does not exist or constructor is not properly defined in Cow class");
        } catch (Exception e) {
            fail("Error testing toString(): " + e.getMessage());
        }
    }
    
    @Test
    public void testEqualsMethod() {
        try {
            Class<?> cowClass = Class.forName("Cow");
            Method equalsMethod = cowClass.getMethod("equals", Object.class);
            assertEquals(boolean.class, equalsMethod.getReturnType(), 
                    "equals() should return boolean");
            
            // Create cow instances if the class exists
            Constructor<?> constructor = cowClass.getConstructor(String.class, int.class, double.class);
            Object cow1 = constructor.newInstance("Molly", 4, 1100.0);
            Object cow2 = constructor.newInstance("Molly", 4, 1100.0);
            Object cow3 = constructor.newInstance("Holly", 4, 1100.0);
            Object cow4 = constructor.newInstance("Molly", 5, 1100.0);
            Object cow5 = constructor.newInstance("Molly", 4, 1200.0);
            
            // Test equals method with all attributes the same
            boolean result1 = (boolean) equalsMethod.invoke(cow1, cow2);
            assertTrue(result1, "equals() should return true when all attributes match");
            
            // Test equals method with different name
            boolean result2 = (boolean) equalsMethod.invoke(cow1, cow3);
            assertFalse(result2, "equals() should return false when names don't match");
            
            // Test equals method with different age
            boolean result3 = (boolean) equalsMethod.invoke(cow1, cow4);
            assertFalse(result3, "equals() should return false when ages don't match");
            
            // Test equals method with different weight
            boolean result4 = (boolean) equalsMethod.invoke(cow1, cow5);
            assertFalse(result4, "equals() should return false when weights don't match");
            
            // Test equals with null and different class
            boolean result5 = (boolean) equalsMethod.invoke(cow1, new Object[]{null});
            assertFalse(result5, "equals() should return false when comparing with null");
            
            boolean result6 = (boolean) equalsMethod.invoke(cow1, "Not a cow");
            assertFalse(result6, "equals() should return false when comparing with object of different class");
        } catch (ClassNotFoundException e) {
            fail("Cow class does not exist");
        } catch (NoSuchMethodException e) {
            fail("equals(Object) method does not exist in Cow class");
        } catch (Exception e) {
            fail("Error testing equals(): " + e.getMessage());
        }
    }
    
    @Test
    public void testCowFieldsExist() {
        try {
            Class<?> cowClass = Class.forName("Cow");
            Field[] fields = cowClass.getDeclaredFields();
            
            boolean hasNameField = Arrays.stream(fields)
                .anyMatch(field -> field.getName().toLowerCase().contains("name") && field.getType() == String.class);
            boolean hasAgeField = Arrays.stream(fields)
                .anyMatch(field -> field.getName().toLowerCase().contains("age") && field.getType() == int.class);
            boolean hasWeightField = Arrays.stream(fields)
                .anyMatch(field -> field.getName().toLowerCase().contains("weight") && field.getType() == double.class);
            
            assertTrue(hasNameField, "Cow class should have a name field of type String");
            assertTrue(hasAgeField, "Cow class should have an age field of type int");
            assertTrue(hasWeightField, "Cow class should have a weight field of type double");
        } catch (ClassNotFoundException e) {
            fail("Cow class does not exist");
        }
    }

    @Test
    public void testStudentClassExists() {
        try {
            Class.forName("Student");
            assertTrue(true);
        } catch (ClassNotFoundException e) {
            fail("Student class does not exist");
        }
    }
    
    @Test
    public void testStudentConstructor() {
        try {
            Class<?> studentClass = Class.forName("Student");
            Constructor<?> constructor = studentClass.getConstructor(String.class, int.class, String.class);
            assertNotNull(constructor, "Constructor with (String, int, String) parameters should exist");
        } catch (ClassNotFoundException e) {
            fail("Student class does not exist");
        } catch (NoSuchMethodException e) {
            fail("Student constructor with (String, int, String) parameters does not exist");
        }
    }
    
    @Test
    public void testGetNameMethod2() {
        try {
            Class<?> studentClass = Class.forName("Student");
            Method getNameMethod = studentClass.getMethod("getName");
            assertEquals(String.class, getNameMethod.getReturnType(), 
                    "getName() should return String");
        } catch (ClassNotFoundException e) {
            fail("Student class does not exist");
        } catch (NoSuchMethodException e) {
            fail("getName() method does not exist in Student class");
        }
    }
    
    @Test
    public void testGetAgeMethod2() {
        try {
            Class<?> studentClass = Class.forName("Student");
            Method getAgeMethod = studentClass.getMethod("getAge");
            assertEquals(int.class, getAgeMethod.getReturnType(), 
                    "getAge() should return int");
        } catch (ClassNotFoundException e) {
            fail("Student class does not exist");
        } catch (NoSuchMethodException e) {
            fail("getAge() method does not exist in Student class");
        }
    }
    
    @Test
    public void testGetStudentNumberMethod() {
        try {
            Class<?> studentClass = Class.forName("Student");
            Method getStudentNumberMethod = studentClass.getMethod("getStudentNumber");
            assertEquals(String.class, getStudentNumberMethod.getReturnType(), 
                    "getStudentNumber() should return String");
        } catch (ClassNotFoundException e) {
            fail("Student class does not exist");
        } catch (NoSuchMethodException e) {
            fail("getStudentNumber() method does not exist in Student class");
        }
    }
    
    @Test
    public void testToStringMethod2() {
        try {
            Class<?> studentClass = Class.forName("Student");
            Method toStringMethod = studentClass.getMethod("toString");
            assertEquals(String.class, toStringMethod.getReturnType(), 
                    "toString() should return String");
            
            // Create a student instance if the class exists
            Constructor<?> constructor = studentClass.getConstructor(String.class, int.class, String.class);
            Object student = constructor.newInstance("Jane Smith", 22, "S67890");
            
            String result = (String) toStringMethod.invoke(student);
            assertEquals("Jane Smith, 22 - S67890", result, 
                    "toString() should return name, age, and student number in the specified format");
        } catch (ClassNotFoundException e) {
            fail("Student class does not exist");
        } catch (NoSuchMethodException e) {
            fail("toString() method does not exist or constructor is not properly defined in Student class");
        } catch (Exception e) {
            fail("Error testing toString(): " + e.getMessage());
        }
    }
    
    @Test
    public void testEqualsMethod2() {
        try {
            Class<?> studentClass = Class.forName("Student");
            Method equalsMethod = studentClass.getMethod("equals", Object.class);
            assertEquals(boolean.class, equalsMethod.getReturnType(), 
                    "equals() should return boolean");
            
            // Create student instances if the class exists
            Constructor<?> constructor = studentClass.getConstructor(String.class, int.class, String.class);
            Object student1 = constructor.newInstance("Alice", 19, "S11111");
            Object student2 = constructor.newInstance("Bob", 21, "S11111");
            Object student3 = constructor.newInstance("Alice", 19, "S22222");
            
            // Test equals method - should be equal because student numbers match
            boolean result1 = (boolean) equalsMethod.invoke(student1, student2);
            assertTrue(result1, "equals() should return true when student numbers match regardless of other attributes");
            
            // Test equals method - should not be equal because student numbers don't match
            boolean result2 = (boolean) equalsMethod.invoke(student1, student3);
            assertFalse(result2, "equals() should return false when student numbers don't match");
            
            // Test equals with null and different class
            boolean result3 = (boolean) equalsMethod.invoke(student1, new Object[]{null});
            assertFalse(result3, "equals() should return false when comparing with null");
            
            boolean result4 = (boolean) equalsMethod.invoke(student1, "Not a student");
            assertFalse(result4, "equals() should return false when comparing with object of different class");
        } catch (ClassNotFoundException e) {
            fail("Student class does not exist");
        } catch (NoSuchMethodException e) {
            fail("equals(Object) method does not exist in Student class");
        } catch (Exception e) {
            fail("Error testing equals(): " + e.getMessage());
        }
    }
    
    @Test
    public void testStudentFieldsExist() {
        try {
            Class<?> studentClass = Class.forName("Student");
            Field[] fields = studentClass.getDeclaredFields();
            
            boolean hasNameField = Arrays.stream(fields)
                .anyMatch(field -> field.getName().toLowerCase().contains("name") && field.getType() == String.class);
            boolean hasAgeField = Arrays.stream(fields)
                .anyMatch(field -> field.getName().toLowerCase().contains("age") && field.getType() == int.class);
            boolean hasStudentNumberField = Arrays.stream(fields)
                .anyMatch(field -> field.getName().toLowerCase().contains("number") && field.getType() == String.class);
            
            assertTrue(hasNameField, "Student class should have a name field of type String");
            assertTrue(hasAgeField, "Student class should have an age field of type int");
            assertTrue(hasStudentNumberField, "Student class should have a studentNumber field of type String");
        } catch (ClassNotFoundException e) {
            fail("Student class does not exist");
        }
    }
}
