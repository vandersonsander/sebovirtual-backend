package br.com.pi.sebovirtual.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;
import java.util.stream.Stream;

public class Utils {
	
	/**
	 * Checks properties that have values other 
	 * than the target object and updates it
	 * 
	 * <p>Ex. 1:</p>
	 * {@code source.setName("John");}</br>
	 * {@code target.setName("Mike");}</br>
	 * 
	 * {@code Util.updateProperties(source, target, false)}</br>
	 * {@code target.getName() // John}
	 * 
	 * <p>Ex. 2:</p>
	 * {@code source.setName("John");}</br>
	 * {@code target.setName("Mike");}</br>
	 * 
	 * {@code source.setAge(null);}</br>
	 * {@code target.setAge(17);}</br>
	 * 
	 * {@code Util.updateProperties(source, target, true);}</br>
	 * {@code target.getName(); // John}</br>
	 * {@code target.getAge(); // 17}</br>
	 * 
	 * @author Vanderson
	 * 
	 */
	public static void updateProperties(Object source, Object target, Boolean ignoreNullValues) {
		if (source == null) return;
		if (target == null) return;
			
		// Checks for methods
		Method[] sourceMethods = source.getClass().getMethods();
		Method[] targetMethods = target.getClass().getMethods();
		Stream.of(targetMethods).forEach((method) -> {
			String methodName = method.getName();
			// We want get methods
			if (methodName.startsWith("get")) {
				// Changes name "getAttribute" to "setAttribute"
				final String name = "set" + methodName.substring(3);
				Object targetValue;
				Object sourceValue = null;
				try {
					// Invokes get method
					targetValue = method.invoke(target, new Object[] {});
					// Serch for the correspondent get method
					Optional<Method> getValue = Stream.of(sourceMethods)
						.filter((fMethod) -> fMethod.getName().equals(method.getName()))
						.findFirst();
					if (getValue.isPresent())
						sourceValue = getValue.get().invoke(source, new Object[] {});
					if (ignoreNullValues ? sourceValue !=  null : true
							&& !sourceValue.equals(targetValue)) {
						// Search for the corresponding set method
						Optional<Method> setValue = Stream.of(targetMethods)
								.filter((fMethod) -> fMethod.getName().equals(name))
								.findFirst();
						if (setValue.isPresent()) 
							setValue.get().invoke(target, sourceValue);
					}
				} catch (IllegalAccessException | IllegalArgumentException
						| InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
