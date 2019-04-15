
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.junit.Test;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class M1QuizV4Tests_VERIFIED {
	String addressPath = "simulation.Address";
	String unitStatePath = "model.units.UnitState";
	String policeUnitPath = "model.units.PoliceUnit";
	String truckPath = "model.units.Truck";
	String carPath = "model.units.Car";
	String reconstructionSpeedPath = "model.units.ReconstructionSpeed";
	String policeTruckPath = "model.units.PoliceTruck";
	String policeCarPath = "model.units.PoliceCar";

	@Test(timeout = 1000)
	public void testClassIsSubclassPoliceTruck() throws Exception {
		testClassIsSubclass(Class.forName(policeTruckPath), Class.forName(policeUnitPath));
	}

	@Test(timeout = 1000)
	public void testClassIsEnumReconstructionSpeed() throws Exception {
		testIsEnum(Class.forName(reconstructionSpeedPath));
	}

	@Test(timeout = 1000)
	public void testEnumValuesReconstructionSpeed() throws Exception {
		String[] inputs = { "SLOW", "MEDIUM", "FAST" };
		testEnumValues(Class.forName(reconstructionSpeedPath), inputs);
	}

	@Test(timeout = 1000)
	public void testClassIsSubclassPoliceCar() throws Exception {
		testClassIsSubclass(Class.forName(policeCarPath), Class.forName(policeUnitPath));
	}

	// typo

	@Test(timeout = 1000)
	public void testConstructorPoliceTruck0() throws Exception {
		Class[] inputs = { String.class, Class.forName(addressPath), int.class,
				Class.forName(reconstructionSpeedPath) };
		testConstructorExists(Class.forName(policeTruckPath), inputs);
	}

	@Test(timeout = 1000)
	public void testConstructorPoliceCar0() throws Exception {
		Class[] inputs = { String.class, Class.forName(addressPath), int.class };
		testConstructorExists(Class.forName(policeCarPath), inputs);
	}

	@Test(timeout = 1000)
	public void testClassIsInterfaceTruck() throws Exception {
		testIsInterface(Class.forName(truckPath));
	}

	@Test(timeout = 1000)
	public void testClassIsInterfaceCar() throws Exception {
		testIsInterface(Class.forName(carPath));
	}

	// typo
	@Test(timeout = 1000)
	public void testInstanceVariablePoliceTruckReconstructionSpeedGetter() throws Exception {
		testGetterMethodExistsInClass(Class.forName(policeTruckPath), "getRspeed",
				Class.forName(reconstructionSpeedPath), true);
	}

	@Test(timeout = 1000)
	public void testInstanceVariablePoliceCarSirenGetter() throws Exception {
		testGetterMethodExistsInClass(Class.forName(policeCarPath), "isSiren", boolean.class, true);
	}

	// typo
	@Test(timeout = 1000)
	public void testInstanceVariablePoliceTruckReconstructionSpeedSetter() throws Exception {
		testSetterMethodExistsInClass(Class.forName(policeTruckPath), "setRspeed",
				Class.forName(reconstructionSpeedPath), false);
	}

	@Test(timeout = 1000)
	public void testInstanceVariablePoliceCarSirenSetter() throws Exception {
		testSetterMethodExistsInClass(Class.forName(policeCarPath), "setSiren", boolean.class, true);
	}

	// typo
	@Test(timeout = 1000)
	public void testInstanceVariablePoliceTruckReconstructionSpeed() throws Exception {
		testInstanceVariableIsPresent(Class.forName(policeTruckPath), "rspeed", true);
		testInstanceVariableIsPrivate(Class.forName(policeTruckPath), "rspeed");
	}

	@Test(timeout = 1000)
	public void testInstanceVariablePoliceCarSiren() throws Exception {
		testInstanceVariableIsPresent(Class.forName(policeCarPath), "siren", true);
		testInstanceVariableIsPrivate(Class.forName(policeCarPath), "siren");
	}

	@Test(timeout = 1000)
	public void testPoliceUnitMaxCapacityNotInClasses() throws Exception {
		testInstanceVariableIsPresent(Class.forName(policeCarPath), "PoliceUnit.maxCapacity", false);
		testInstanceVariableIsPresent(Class.forName(policeTruckPath), "PoliceUnit.maxCapacity", false);
	}

	@Test(timeout = 1000)
	public void testPoliceTruckImplementsTruck() throws Exception {
		testClassImplementsInterface(Class.forName(policeTruckPath), Class.forName(truckPath));
	}

	@Test(timeout = 1000)
	public void testPoliceCarImplementsCar() throws Exception {
		testClassImplementsInterface(Class.forName(policeCarPath), Class.forName(carPath));
	}

	@Test(timeout = 1000)
	public void testInstanceVariablePoliceCarSirenGetterLogic0() throws Exception {
		String String3 = "givxsdgv";
		int int3 = 3;
		int int8 = 8;
		Object address0 = Class.forName(addressPath).getConstructor(int.class, int.class).newInstance(int3, int8);
		int int6 = 6;
		Object policeCar0 = Class.forName(policeCarPath)
				.getConstructor(String.class, Class.forName(addressPath), int.class)
				.newInstance(String3, address0, int6);
		testGetterLogic(policeCar0, "siren", true);
		testGetterLogic(policeCar0, "siren", false);
	}

	@Test(timeout = 1000)
	public void testInstanceVariablePoliceCarMaxCapacityGetterLogic0() throws Exception {
		String String3 = "givxsdgv";
		int int3 = 3;
		int int8 = 8;
		Object address0 = Class.forName(addressPath).getConstructor(int.class, int.class).newInstance(int3, int8);
		int int6 = 6;
		Object policeCar0 = Class.forName(policeCarPath)
				.getConstructor(String.class, Class.forName(addressPath), int.class)
				.newInstance(String3, address0, int6);
		testGetterLogic(policeCar0, "maxCapacity", 6);
	}

	@Test(timeout = 1000)
	public void testInstanceVariablePoliceTruckReconstructionSpeedGetterLogic0() throws Exception {
		String String4 = "loyovlkqu";
		int int3 = 3;
		int int8 = 8;
		Object address0 = Class.forName(addressPath).getConstructor(int.class, int.class).newInstance(int3, int8);
		int int0 = 0;
		Object reconstructionSpeed2 = Enum.valueOf((Class<Enum>) Class.forName(reconstructionSpeedPath), "FAST");
		Object policeTruck0 = Class.forName(policeTruckPath)
				.getConstructor(String.class, Class.forName(addressPath), int.class,
						Class.forName(reconstructionSpeedPath))
				.newInstance(String4, address0, int0, reconstructionSpeed2);
		testGetterLogic(policeTruck0, "rspeed",
				Enum.valueOf((Class<Enum>) Class.forName(reconstructionSpeedPath), "FAST"));

		reconstructionSpeed2 = Enum.valueOf((Class<Enum>) Class.forName(reconstructionSpeedPath), "MEDIUM");
		policeTruck0 = Class.forName(policeTruckPath)
				.getConstructor(String.class, Class.forName(addressPath), int.class,
						Class.forName(reconstructionSpeedPath))
				.newInstance(String4, address0, int0, reconstructionSpeed2);
		testGetterLogic(policeTruck0, "rspeed",
				Enum.valueOf((Class<Enum>) Class.forName(reconstructionSpeedPath), "MEDIUM"));

	}

	@Test(timeout = 1000)
	public void testInstanceVariablePoliceTruckMaxCapacityGetterLogic0() throws Exception {
		String String4 = "loyovlkqu";
		int int3 = 3;
		int int8 = 8;
		Object address0 = Class.forName(addressPath).getConstructor(int.class, int.class).newInstance(int3, int8);
		int int0 = 0;
		Object reconstructionSpeed2 = Enum.valueOf((Class<Enum>) Class.forName(reconstructionSpeedPath), "FAST");
		Object policeTruck0 = Class.forName(policeTruckPath)
				.getConstructor(String.class, Class.forName(addressPath), int.class,
						Class.forName(reconstructionSpeedPath))
				.newInstance(String4, address0, int0, reconstructionSpeed2);
		testGetterLogic(policeTruck0, "maxCapacity", 20);
	}

	@Test(timeout = 1000)
	public void testInstanceVariablePoliceCarSirenSetterLogic0() throws Exception {
		String String3 = "givxsdgv";
		int int3 = 3;
		int int8 = 8;
		Object address0 = Class.forName(addressPath).getConstructor(int.class, int.class).newInstance(int3, int8);
		int int6 = 6;
		Object policeCar0 = Class.forName(policeCarPath)
				.getConstructor(String.class, Class.forName(addressPath), int.class)
				.newInstance(String3, address0, int6);
		testSetterLogic(policeCar0, "siren", false, boolean.class);
		testSetterLogic(policeCar0, "siren", true, boolean.class);
	}

	@Test(timeout = 1000)
	public void testConstructorPoliceCarConstructor0Initialization() throws Exception {
		Random x = new Random();

		int int3 = x.nextInt(9);
		int int8 = x.nextInt(9);
		String String3 = "givxsdgv" + int3;
		Object address0 = Class.forName(addressPath).getConstructor(int.class, int.class).newInstance(int3, int8);
		int int6 = x.nextInt(9);
		Object policeCar0 = Class.forName(policeCarPath)
				.getConstructor(String.class, Class.forName(addressPath), int.class)
				.newInstance(String3, address0, int6);
		String[] names = { "siren", "passengers", "maxCapacity", "distanceToBase", "unitID", "state", "location",
				"distanceToTarget", "stepsPerCycle" };
		Object[] values = { true, new ArrayList<>(), 6, 0, String3,
				Enum.valueOf((Class<Enum>) Class.forName(unitStatePath), "IDLE"), address0, 0, int6 };
		testConstructorInitialization(policeCar0, names, values);
	}

	@Test(timeout = 1000)
	public void testConstructorPoliceTruckConstructor0Initialization() throws Exception {

		Random x = new Random();
		int int3 = x.nextInt(9);
		int int8 = x.nextInt(9);
		String String4 = "loyovlkqu" + int3;
		Object address0 = Class.forName(addressPath).getConstructor(int.class, int.class).newInstance(int3, int8);
		int int0 = 0;
		Object reconstructionSpeed2 = Enum.valueOf((Class<Enum>) Class.forName(reconstructionSpeedPath), "FAST");
		Object policeTruck0 = Class.forName(policeTruckPath)
				.getConstructor(String.class, Class.forName(addressPath), int.class,
						Class.forName(reconstructionSpeedPath))
				.newInstance(String4, address0, int0, reconstructionSpeed2);
		String[] names = { "rspeed", "passengers", "maxCapacity", "distanceToBase", "unitID", "state", "location",
				"distanceToTarget", "stepsPerCycle" };
		Object[] values = { Enum.valueOf((Class<Enum>) Class.forName(reconstructionSpeedPath), "FAST"),
				new ArrayList<>(), 20, 0, String4, Enum.valueOf((Class<Enum>) Class.forName(unitStatePath), "IDLE"),
				address0, 0, 0 };
		testConstructorInitialization(policeTruck0, names, values);

		reconstructionSpeed2 = Enum.valueOf((Class<Enum>) Class.forName(reconstructionSpeedPath), "MEDIUM");
		policeTruck0 = Class.forName(policeTruckPath)
				.getConstructor(String.class, Class.forName(addressPath), int.class,
						Class.forName(reconstructionSpeedPath))
				.newInstance(String4, address0, int0, reconstructionSpeed2);
		String[] names1 = { "rspeed", "passengers", "maxCapacity", "distanceToBase", "unitID", "state", "location",
				"distanceToTarget", "stepsPerCycle" };
		Object[] values1 = { Enum.valueOf((Class<Enum>) Class.forName(reconstructionSpeedPath), "MEDIUM"),
				new ArrayList<>(), 20, 0, String4, Enum.valueOf((Class<Enum>) Class.forName(unitStatePath), "IDLE"),
				address0, 0, 0 };
		testConstructorInitialization(policeTruck0, names1, values1);
	}

// ############################################# Helper methods

	public void testEnumValues(Class aClass, String[] value) throws ClassNotFoundException {
		for (int i = 0; i < value.length; i++) {
			try {
				Enum.valueOf((Class<Enum>) aClass, value[i]);
			} catch (IllegalArgumentException e) {
				fail(aClass.getSimpleName() + " enum can be " + value[i]);
			}
		}
	}

	private void testInstanceVariableIsPresent(Class aClass, String varName, boolean implementedVar)
			throws SecurityException {
		boolean thrown = false;
		try {
			aClass.getDeclaredField(varName);
		} catch (NoSuchFieldException e) {
			thrown = true;
		}
		if (implementedVar) {
			assertFalse(
					"There should be \"" + varName + "\" instance variable in class " + aClass.getSimpleName() + ".",
					thrown);
		} else {
			assertTrue("The instance variable \"" + varName + "\" should not be declared in class "
					+ aClass.getSimpleName() + ".", thrown);
		}
	}

	private void testInstanceVariableIsPrivate(Class aClass, String varName)
			throws NoSuchFieldException, SecurityException {
		Field f = aClass.getDeclaredField(varName);
		assertEquals("The \"" + varName + "\" instance variable in class " + aClass.getSimpleName()
				+ " should not be accessed outside that class.", 2, f.getModifiers());
	}

	private void testGetterMethodExistsInClass(Class aClass, String methodName, Class returnedType,
			boolean writeVariable) {
		Method m = null;
		boolean found = true;
		try {
			m = aClass.getDeclaredMethod(methodName);
		} catch (Exception e) {
			found = false;
		}
		String varName = "";
		if (returnedType == boolean.class)
			varName = methodName.substring(2).toLowerCase();
		else
			varName = methodName.substring(3).toLowerCase();
		if (writeVariable) {
			assertTrue("The \"" + varName + "\" instance variable in class " + aClass.getSimpleName()
					+ " is a READ variable.", found);
			assertTrue("Incorrect return type for " + methodName + " method in " + aClass.getSimpleName() + " class.",
					m.getReturnType().isAssignableFrom(returnedType));
		} else {
			assertFalse("The \"" + varName + "\" instance variable in class " + aClass.getSimpleName()
					+ " is not a READ variable.", found);
		}
	}

	private void testSetterMethodExistsInClass(Class aClass, String methodName, Class inputType,
			boolean writeVariable) {
		Method[] methods = aClass.getDeclaredMethods();
		String varName = methodName.substring(3).toLowerCase();
		if (writeVariable) {
			assertTrue("The \"" + varName + "\" instance variable in class " + aClass.getSimpleName()
					+ " is a WRITE variable.", containsMethodName(methods, methodName));
		} else {
			assertFalse("The \"" + varName + "\" instance variable in class " + aClass.getSimpleName()
					+ " is not a WRITE variable.", containsMethodName(methods, methodName));
			return;
		}
		Method m = null;
		boolean found = true;
		try {
			m = aClass.getDeclaredMethod(methodName, inputType);
		} catch (NoSuchMethodException e) {
			found = false;
		}
		assertTrue(aClass.getSimpleName() + " class should have " + methodName + " method that takes one "
				+ inputType.getSimpleName() + " parameter.", found);
		assertTrue("Incorrect return type for " + methodName + " method in " + aClass.getSimpleName() + ".",
				m.getReturnType().equals(Void.TYPE));
	}

	private static boolean containsMethodName(Method[] methods, String name) {
		for (Method method : methods) {
			if (method.getName().equals(name))
				return true;
		}
		return false;
	}

	private void testConstructorExists(Class aClass, Class[] inputs) {
		boolean thrown = false;
		try {
			aClass.getConstructor(inputs);
		} catch (NoSuchMethodException e) {
			thrown = true;
		}
		if (inputs.length > 0) {
			String msg = "";
			int i = 0;
			do {
				msg += inputs[i].getSimpleName() + " and ";
				i++;
			} while (i < inputs.length);
			msg = msg.substring(0, msg.length() - 4);
			assertFalse("Missing constructor with " + msg + " parameter" + (inputs.length > 1 ? "s" : "") + " in "
					+ aClass.getSimpleName() + " class.", thrown);
		} else
			assertFalse("Missing constructor with zero parameters in " + aClass.getSimpleName() + " class.", thrown);
	}

	private void testIsInterface(Class aClass) {
		assertEquals(aClass.getName() + " should be an Interface", aClass.isInterface(), true);
	}

	private void testIsEnum(Class aClass) {
		assertEquals(aClass.getName() + " should be an Enum", aClass.isEnum(), true);
	}

	private void testClassIsSubclass(Class subClass, Class superClass) {
		assertEquals(subClass.getSimpleName() + " class should be a subclass from " + superClass.getSimpleName() + ".",
				superClass, subClass.getSuperclass());
	}

	private void testConstructorInitialization(Object createdObject, String[] names, Object[] values)
			throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException {
		for (int i = 0; i < names.length; i++) {
			Field f = null;
			Class curr = createdObject.getClass();
			String currName = names[i];
			Object currValue = values[i];
			while (f == null) {
				if (curr == Object.class)
					fail("Class " + createdObject.getClass().getSimpleName() + " should have the instance variable \""
							+ currName + "\".");
				try {
					f = curr.getDeclaredField(currName);
				} catch (NoSuchFieldException e) {
					curr = curr.getSuperclass();
				}
			}
			f.setAccessible(true);
			assertEquals(
					"The constructor of the " + createdObject.getClass().getSimpleName()
							+ " class should initialize the instance variable \"" + currName + "\" correctly.",
					currValue, f.get(createdObject));
		}
	}

	private void testGetterLogic(Object createdObject, String name, Object value) throws Exception {
		Field f = null;
		Class curr = createdObject.getClass();
		while (f == null) {
			if (curr == Object.class)
				fail("Class " + createdObject.getClass().getSimpleName() + " should have the instance variable \""
						+ name + "\".");
			try {
				f = curr.getDeclaredField(name);
			} catch (NoSuchFieldException e) {
				curr = curr.getSuperclass();
			}
		}
		f.setAccessible(true);
		f.set(createdObject, value);
		Character c = name.charAt(0);
		String methodName = "get" + Character.toUpperCase(c) + name.substring(1, name.length());
		if (value.getClass().equals(Boolean.class))
			methodName = "is" + Character.toUpperCase(c) + name.substring(1, name.length());
		Method m = createdObject.getClass().getMethod(methodName);
		assertEquals(
				"The method \"" + methodName + "\" in class " + createdObject.getClass().getSimpleName()
						+ " should return the correct value of variable \"" + name + "\".",
				value, m.invoke(createdObject));
	}

	private void testSetterLogic(Object createdObject, String name, Object value, Class type) throws Exception {
		Field f = null;
		Class curr = createdObject.getClass();
		while (f == null) {

			if (curr == Object.class)
				fail("Class " + createdObject.getClass().getSimpleName() + " should have the instance variable \""
						+ name + "\".");
			try {
				f = curr.getDeclaredField(name);
			} catch (NoSuchFieldException e) {
				curr = curr.getSuperclass();
			}
		}
		f.setAccessible(true);
		Character c = name.charAt(0);
		String methodName = "set" + Character.toUpperCase(c) + name.substring(1, name.length());
		Method m = createdObject.getClass().getMethod(methodName, type);
		m.invoke(createdObject, value);
		assertEquals("The method \"" + methodName + "\" in class " + createdObject.getClass().getSimpleName()
				+ " should set the correct value of variable \"" + name + "\".", value, f.get(createdObject));
	}

	static void Decrypt(String key, String input, File outputFile) {
		try {

			Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);

			byte[] inputBytes = DatatypeConverter.parseHexBinary(input);
			byte[] outputBytes = cipher.doFinal(inputBytes);

			FileOutputStream outputStream = new FileOutputStream(outputFile);
			outputStream.write(outputBytes);

			outputStream.close();

		} catch (NoSuchPaddingException | NoSuchAlgorithmException | InvalidKeyException | BadPaddingException
				| IllegalBlockSizeException | IOException e) {
			Scanner sc = new Scanner(System.in);
			sc.close();
			e.printStackTrace();
		}
	}

	static void fixKeyLength() {
		String errorString = "Failed manually overriding key-length permissions.";
		int newMaxKeyLength;
		try {
			if ((newMaxKeyLength = Cipher.getMaxAllowedKeyLength("AES")) < 256) {
				Class c = Class.forName("javax.crypto.CryptoAllPermissionCollection");
				Constructor con = c.getDeclaredConstructor();
				con.setAccessible(true);
				Object allPermissionCollection = con.newInstance();
				Field f = c.getDeclaredField("all_allowed");
				f.setAccessible(true);
				f.setBoolean(allPermissionCollection, true);

				c = Class.forName("javax.crypto.CryptoPermissions");
				con = c.getDeclaredConstructor();
				con.setAccessible(true);
				Object allPermissions = con.newInstance();
				f = c.getDeclaredField("perms");
				f.setAccessible(true);
				((Map) f.get(allPermissions)).put("*", allPermissionCollection);

				c = Class.forName("javax.crypto.JceSecurityManager");
				f = c.getDeclaredField("defaultPolicy");
				f.setAccessible(true);
				Field mf = Field.class.getDeclaredField("modifiers");
				mf.setAccessible(true);
				mf.setInt(f, f.getModifiers() & ~Modifier.FINAL);
				f.set(null, allPermissions);

				newMaxKeyLength = Cipher.getMaxAllowedKeyLength("AES");
			}
		} catch (Exception e) {
			throw new RuntimeException(errorString, e);
		}
		if (newMaxKeyLength < 256)
			throw new RuntimeException(errorString); // hack failed
	}

	private void testClassImplementsInterface(Class aClass, Class interfaceName) {
		Class[] interfaces = aClass.getInterfaces();
		boolean implement = false;
		for (Class i : interfaces) {
			if (i.toString().equals(interfaceName.toString()))
				implement = true;
		}
		assertTrue(aClass.getSimpleName() + " class should implement " + interfaceName.getSimpleName() + " interface.",
				implement);
	}
}