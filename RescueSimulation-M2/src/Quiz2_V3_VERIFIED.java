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
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.junit.Test;

import controller.CommandCenter;
import model.disasters.Collapse;
import model.disasters.Disaster;
import model.disasters.Fire;
import model.disasters.GasLeak;
import model.disasters.Infection;
import model.disasters.Injury;
import model.events.SOSListener;
import model.events.WorldListener;
import model.infrastructure.ResidentialBuilding;
import model.people.Citizen;
import model.people.CitizenState;
import model.units.Ambulance;
import model.units.DiseaseControlUnit;
import model.units.Evacuator;
import model.units.FireTruck;
import model.units.GasControlUnit;
import model.units.MedicalUnit;
import model.units.Unit;
import model.units.UnitState;
import simulation.Address;
import simulation.Rescuable;
import simulation.Simulator;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class Quiz2_V3_VERIFIED {
	
	static final String buildingPath = "model.infrastructure.ResidentialBuilding";
	static final String disasterPath = "model.disasters.Disaster";
	static final String sosListenerPath = "model.events.SOSListener";

	static String simulatorPath = "simulation.Simulator";
	static String addressPath = "simulation.Address";
	static String rescuablePath = "simulation.Rescuable";
	static String simulatablePath = "simulation.Simulatable";
	static String residentialBuildingPath = "model.infrastructure.ResidentialBuilding";
	static String citizenStatePath = "model.people.CitizenState";
	static String unitStatePath = "model.units.UnitState";
	static String citizenPath = "model.people.Citizen";
	static String unitPath = "model.units.Unit";
	static String policeUnitPath = "model.units.PoliceUnit";
	static String fireUnitPath = "model.units.FireUnit";
	static String medicalUnitPath = "model.units.MedicalUnit";
	static String evacuatorPath = "model.units.Evacuator";
	static String fireTruckPath = "model.units.FireTruck";
	static String gasControlUnitPath = "model.units.GasControlUnit";
	static String ambulancePath = "model.units.Ambulance";
	static String diseaseControlUnitPath = "model.units.DiseaseControlUnit";
	static String collapsePath = "model.disasters.Collapse";
	static String firePath = "model.disasters.Fire";
	static String gasLeakPath = "model.disasters.GasLeak";
	static String infectionPath = "model.disasters.Infection";
	static String injuryPath = "model.disasters.Injury";
	static String commandCenterPath = "controller.CommandCenter";
	static String worldListenerPath = "model.events.WorldListener";
	static String sosResponderPath = "model.events.SOSResponder";

	public static boolean treatCalled = false;
	public static boolean healCalled = false;
	@SuppressWarnings("unused")
	private static boolean struckByCalled = false;

	HashMap<String, Integer> count;
	SOSListener sos = new SOSListener() {

		@Override
		public void receiveSOSCall(Rescuable r) {

		}
	};

	@Test(timeout = 1000)
	public void testInstanceVariableCitizenOxygenLevel() throws Exception {
		testInstanceVariableIsPresent(Class.forName(citizenPath), "oxygenLevel", true);
		testInstanceVariableIsPrivate(Class.forName(citizenPath), "oxygenLevel");
	}

	@Test(timeout = 1000)
	public void testInstanceVariableCitizenOxygenLevelGetterAndSetter() throws Exception {
		testGetterMethodExistsInClass(Class.forName(citizenPath), "getOxygenLevel", int.class, true);
		testSetterMethodExistsInClass(Class.forName(citizenPath), "setOxygenLevel", int.class, true);
	}

	@Test(timeout = 1000)
	public void testInstanceVariableCitizenOxygenLevelGetterLogic() throws Exception {
		int int7 = 7;
		int int4 = 4;
		Object address2 = Class.forName(addressPath).getConstructor(int.class, int.class).newInstance(int7, int4);
		String String9 = "dds";
		String String5 = "pfa";
		int int5 = 5;
		Object citizen1 = Class.forName(citizenPath).getConstructor(Class.forName(addressPath), String.class,
				String.class, int.class, Class.forName(worldListenerPath))
				.newInstance(address2, String9, String5, int5, null);
		testGetterLogic(citizen1, "toxicity", 100);
	}

	@Test(timeout = 1000)
	public void testCitizenOxygenLevelSetterBounds() throws Exception {

		Citizen ct = someRandomCitizen();
		int r = (int) (Math.random() * 100) + 100;
		ct.setOxygenLevel(r);

		Field ol = null;
		try {

			ol = Citizen.class.getDeclaredField("oxygenLevel");
			ol.setAccessible(true);
			int oxyLevel = (int) ol.get(ct);

			assertEquals("The oxygenLevel value of any Citizen can not be set to more than 100.", 100, oxyLevel);

			ct = someRandomCitizen();
			r = (int) (Math.random() * 100) * -1;
			ct.setOxygenLevel(r);

			oxyLevel = (int) ol.get(ct);

			assertEquals("The oxygenLevel value of any Citizen can not be set to less than 0.", 0, oxyLevel);

		} catch (NoSuchFieldException e) {
			fail("Class Citizen should have oxygenLevel instance variable");

		}

	}

	@Test(timeout = 1000)
	public void testCitizenOxygenLevelZeroSetsHptoZero() throws Exception {

		Citizen ct = someRandomCitizen();

		int r = (int) (Math.random() * 100) * -1;
		ct.setOxygenLevel(r);

		Field fieldHp = Citizen.class.getDeclaredField("hp");
		fieldHp.setAccessible(true);
		int hp = (int) fieldHp.get(ct);

		assertEquals("The Hp of a Citizen with OxygenLevel equal to 0, should be set to 0.", 0, hp);
		assertTrue("The State of a Citizen with OxygenLevel equal to 0, should be set to DECEASED.",
				ct.getState() == CitizenState.DECEASED);

	}

	@Test(timeout = 1000)
	public void testCitizenConstructorInitializationOxygenLevel() throws Exception {
		int int7 = 7;
		int int4 = 4;
		Object address2 = Class.forName(addressPath).getConstructor(int.class, int.class).newInstance(int7, int4);
		String String9 = "dds";
		String String5 = "pfa";
		int int5 = 5;
		Object citizen1 = Class.forName(citizenPath)
				.getConstructor(Class.forName(addressPath), String.class, String.class, int.class, WorldListener.class)
				.newInstance(address2, String9, String5, int5, null);
		String[] names = { "oxygenLevel" };
		Object[] values = { 100 };
		testConstructorInitialization(citizen1, names, values);
	}

	@Test(timeout = 5000)
	public void testStrikeGasLeak() throws Exception {
		testExistsInClass(GasLeak.class, "strike", true, void.class);

		int int8 = 8;
		int int5 = 5;
		Address address0 = new Address(int8, int5);
		ResidentialBuilding residentialBuilding2 = new ResidentialBuilding(address0) {
			@Override
			public void struckBy(Disaster d) {
				struckByCalled = true;
			}
		};

		for (int i = 0; i < 5; i++) {
			Citizen a = someRandomCitizen();
			residentialBuilding2.getOccupants().add(a);
			Field oxygenlevelfield = Citizen.class.getDeclaredField("oxygenLevel");
			oxygenlevelfield.setAccessible(true);
			oxygenlevelfield.set(a, 100);
		}
		GasLeak gasLeak2 = new GasLeak(0, residentialBuilding2);

		gasLeak2.strike();
		assertTrue("Method \"strike\" in class \"GasLeak\" should set the initial \"gasLevel\" to 10",
				residentialBuilding2.getGasLevel() == 10);

		ArrayList<Citizen> occs = residentialBuilding2.getOccupants();
		for (int i = 0; i < occs.size(); i++) {
			Citizen c = occs.get(i);
			System.out.println(c.getOxygenLevel());
			assertEquals(
					"Method \"strike\" in class \"GasLeak\" should decrement the \"oxygenLevel\" of the building occupants by 15",
					85, c.getOxygenLevel());

		}

	}

	@Test(timeout = 5000)
	public void testCycleStepGasLeak() throws Exception {

		testExistsInClass(GasLeak.class, "cycleStep", true, void.class);

		int int8 = 8;
		int int5 = 5;
		Address address0 = new Address(int8, int5);
		ResidentialBuilding residentialBuilding2 = new ResidentialBuilding(address0);
		for (int i = 0; i < 5; i++) {
			Citizen a = someRandomCitizen();
			residentialBuilding2.getOccupants().add(a);
			Field oxygenlevelfield = Citizen.class.getDeclaredField("oxygenLevel");
			oxygenlevelfield.setAccessible(true);
			oxygenlevelfield.set(a, 100);
		}
		GasLeak gasLeak2 = new GasLeak(0, residentialBuilding2);
		gasLeak2.setActive(true);

		for (int i = 1; i <= 5; i++) {
			gasLeak2.cycleStep();
			assertTrue(
					"Method \"cycleStep\" in class \"GasLeak\" should set the \"gasLevel\" to " + i * 15 + " by cycle "
							+ i + " but was " + residentialBuilding2.getGasLevel(),
					residentialBuilding2.getGasLevel() == i * 15);

			ArrayList<Citizen> occs = residentialBuilding2.getOccupants();
			for (int j = 0; j < occs.size(); j++) {
				Citizen c = occs.get(j);
				System.out.println(c.getOxygenLevel());
				assertTrue(
						"Method \"cycleStep\" in class \"GasLeak\" should set the \"oxygenLevel\" of the building occupants to "
								+ (100 - (i * 15)) + " by cycle " + i + " but was " + c.getOxygenLevel(),
						c.getOxygenLevel() == 100 - (i * 15));

			}
		}
	}

	@Test(timeout = 1000)
	public void testGasControlUnitTreatLogic() throws Exception {
		Simulator s = new Simulator(sos);
		GasControlUnit u = new GasControlUnit("GCU1", new Address(3, 4), 3, null);
		u.setWorldListener(s);
		ResidentialBuilding c1 = new ResidentialBuilding(new Address(3, 9));
		for (int i = 0; i < 5; i++) {
			Citizen a = someRandomCitizen();
			a.setOxygenLevel(15);
			c1.getOccupants().add(a);
		}
		Disaster d = new GasLeak(3, c1);
		dshelper(d);
		c1.setGasLevel(50);

		unitRespond(u, c1, 5);

		ArrayList<Integer> gasLevelValues = new ArrayList<Integer>();
		gasLevelValues.add(40);
		gasLevelValues.add(30);
		gasLevelValues.add(20);
		gasLevelValues.add(10);
		gasLevelValues.add(0);

		ArrayList<Integer> oxygenLevelValues = new ArrayList<Integer>();
		oxygenLevelValues.add(30);
		oxygenLevelValues.add(45);
		oxygenLevelValues.add(60);
		oxygenLevelValues.add(75);
		oxygenLevelValues.add(90);

		for (int i = 0; i < 5; i++) {
			u.treat();
			assertTrue("Values of building gas level were wrong, expected " + gasLevelValues.get(i) + " but was "
					+ c1.getGasLevel() + ".", gasLevelValues.get(i) == c1.getGasLevel());

			ArrayList<Citizen> occs = c1.getOccupants();
			for (int j = 0; j < occs.size(); j++) {
				Citizen c = occs.get(j);
				assertTrue("Values of Citizen oxygen level were wrong, expected " + oxygenLevelValues.get(i)
						+ " but was " + c.getOxygenLevel() + ".", oxygenLevelValues.get(i) == c.getOxygenLevel());
			}
		}
		u.cycleStep();

	}

//	Address testAddress1 = new Address(0, 0);
//	Address testAddress2 = new Address(1, 1);
//	Address testAddress3 = new Address(2, 3);
//	Address testAddress4 = new Address(4, 4);
//
//	String id1 = "1";
//	String id2 = "2";
//	String id3 = "3";
//	String id4 = "4";
//
//	String name1 = "test1";
//	String name2 = "test2";
//	String name3 = "test3";
//	String name4 = "test4";
//
//	int age1 = 24;
//	int age2 = 25;
//	int age3 = 26;
//	int age4 = 27;
//
//	Citizen testCitizen1 = new Citizen(testAddress1, id1, name1, age1, null);
//	Citizen testCitizen2 = new Citizen(testAddress2, id2, name2, age2, null);
//	Citizen testCitizen3 = new Citizen(testAddress3, id3, name3, age3, null);
//	Citizen testCitizen4 = new Citizen(testAddress4, id4, name4, age4, null);
//
//	ResidentialBuilding testBuilding1 = new ResidentialBuilding(testAddress1);
//	ResidentialBuilding testBuilding2 = new ResidentialBuilding(testAddress2);
//	ResidentialBuilding testBuilding3 = new ResidentialBuilding(testAddress3);
//	ResidentialBuilding testBuilding4 = new ResidentialBuilding(testAddress4);
//
//	Ambulance testAmbulance = new Ambulance(id1, testAddress1, 1, null);
//	Evacuator testEvacutor = new Evacuator(id2, testAddress1, 1, null, 5);
//	FireTruck testFireTruck = new FireTruck(id3, testAddress1, 1, null);
//	DiseaseControlUnit testDiseaseContorlUnit = new DiseaseControlUnit(id4,
//			testAddress1, 1, null);
//	GasControlUnit testGasContorlUnit = new GasControlUnit("5", testAddress1,
//			1, null);
//
//	Collapse testCollapse = new Collapse(1, testBuilding1);
//	Fire testFire = new Fire(3, testBuilding1);
//	GasLeak testGasLeak = new GasLeak(3, testBuilding1);
//	Infection testiInfection = new Infection(1, testCitizen1);
//	Injury testinjInjury = new Injury(2, testCitizen2);

//	Infection testInfection = new Infection(1, testCitizen1);
//	Injury testInjury = new Injury(2, testCitizen2);
	
	

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

	private void testExistsInClass(Class aClass, String methodName, boolean implementedMethod, Class returnType,
			Class... inputTypes) {

		Method[] methods = aClass.getDeclaredMethods();

		if (implementedMethod) {
			assertTrue("The " + methodName + " method in class " + aClass.getSimpleName() + " should be implemented.",
					containsMethodName(methods, methodName));
		} else {
			assertFalse(
					"The " + methodName + " method in class " + aClass.getSimpleName()
							+ " should not be implemented, only inherited from super class.",
					containsMethodName(methods, methodName));
			return;
		}
		Method m = null;
		boolean found = true;
		try {
			m = aClass.getDeclaredMethod(methodName, inputTypes);
		} catch (Exception e) {
			found = false;
		}

		String inputsList = "";
		for (Class inputType : inputTypes) {
			inputsList += inputType.getSimpleName() + ", ";
		}
		if (inputsList.equals(""))
			assertTrue(
					aClass.getSimpleName() + " class should have " + methodName + " method that takes no parameters.",
					found);
		else {
			if (inputsList.charAt(inputsList.length() - 1) == ' ')
				inputsList = inputsList.substring(0, inputsList.length() - 2);
			assertTrue(aClass.getSimpleName() + " class should have " + methodName + " method that takes " + inputsList
					+ " parameter(s).", found);
		}

		assertTrue("incorrect return type for " + methodName + " method in " + aClass.getSimpleName() + ".",
				m.getReturnType().equals(returnType));

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

	private static void unitRespond(Unit u, Rescuable r, int dist)
			throws IllegalArgumentException, IllegalAccessException {
		if (r != null && u.getState() == UnitState.TREATING) {

			Disaster curr = r.getDisaster();
			curr.setActive(true);
		}

		Field targetField = null;
		Class curr0 = u.getClass();
		while (targetField == null) {
			if (curr0 == Object.class)
				fail("Class " + u.getClass().getSimpleName() + " should have the instance variable \"" + "disaster"
						+ "\".");
			try {
				targetField = curr0.getDeclaredField("target");
			} catch (NoSuchFieldException e) {
				curr0 = curr0.getSuperclass();
			}
		}
		targetField.setAccessible(true);
		targetField.set(u, r);

		u.setState(UnitState.RESPONDING);
		int distanceToTarget = dist;

		Field f = null;
		Class curr = u.getClass();
		while (f == null) {
			if (curr == Object.class)
				fail("Class " + u.getClass().getSimpleName() + " should have the instance variable \"" + "disaster"
						+ "\".");
			try {
				f = curr.getDeclaredField("distanceToTarget");
			} catch (NoSuchFieldException e) {
				curr = curr.getSuperclass();
			}
		}
		f.setAccessible(true);
		f.set(u, distanceToTarget);

	}

	private static void dshelper(Disaster d) throws IllegalArgumentException, IllegalAccessException {
		Rescuable target = d.getTarget();
		if (target instanceof Citizen) {
			Citizen c = (Citizen) target;
			Field f = null;
			Class curr = c.getClass();
			while (f == null) {
				if (curr == Object.class)
					fail("Class " + c.getClass().getSimpleName() + " should have the instance variable \"" + "disaster"
							+ "\".");
				try {
					f = curr.getDeclaredField("disaster");
				} catch (NoSuchFieldException e) {
					curr = curr.getSuperclass();
				}
			}
			f.setAccessible(true);
			f.set(c, d);
		} else {
			ResidentialBuilding b = (ResidentialBuilding) target;
			Field f = null;
			Class curr = b.getClass();
			while (f == null) {
				if (curr == Object.class)
					fail("Class " + b.getClass().getSimpleName() + " should have the instance variable \"" + "disaster"
							+ "\".");
				try {
					f = curr.getDeclaredField("disaster");
				} catch (NoSuchFieldException e) {
					curr = curr.getSuperclass();
				}
			}
			f.setAccessible(true);
			f.set(b, d);
		}
		d.setActive(true);
	}

	private Address someRandomAddress() {
		int x = (int) (Math.random() * 11);
		int y = (int) (Math.random() * 11);
		return new Address(x, y);
	}

	private Citizen someRandomCitizen() {

		Address add = someRandomAddress();
		String id = "ID_" + (Math.random() * 2309);
		String name = "Citizen_" + (Math.random() * 2387);
		int age = (int) (Math.random() * 50);

		return new Citizen(add, id, name, age, null);
	}

	public class MyDisaster extends Disaster {

		public MyDisaster(int i, Citizen c1) {
			super(i, c1);
		}

		@Override
		public void cycleStep() {

		}

	}

	class MyMedicalUnit extends MedicalUnit {

		public MyMedicalUnit(String unitID, Address location, int stepsPerCycle) {
			super(unitID, location, stepsPerCycle, null);
		}

		@Override
		public void treat() {

		}

		public void cycleStep() {

		}

	}

}