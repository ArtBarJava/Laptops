import java.util.*;

public class Main {

    public static void main(String[] args) {
        Set<ManyLaptops> notebooks = new HashSet<>(); 
        notebooks.add(new ManyLaptops("Lenovo", 8, 512, "Windows 10", "Intel"));
        notebooks.add(new ManyLaptops("HP", 16, 1024, "Windows 10", "AMD"));
        notebooks.add(new ManyLaptops("Dell", 12, 256, "Linux", "Intel"));
        notebooks.add(new ManyLaptops("Acer", 4, 512, "Windows 11", "Intel"));
        notebooks.add(new ManyLaptops("MacBook", 24, 1024, "MacOS", "M3"));

        // Запросим у пользователя критерии фильтрации
        Map<Integer, Object> filters = new HashMap<>();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите цифру, соответствующую необходимому критерию:");
            System.out.println("1 - ОЗУ");
            System.out.println("2 - Объем ЖД");
            System.out.println("3 - Операционная система");

            
            int criterion = scanner.nextInt();
            int minValue;
            if (criterion == 1 || criterion == 2) { 
                System.out.println("Введите минимальное значение для критерия:");
                minValue = scanner.nextInt();
                filters.put(criterion, minValue);
            } else if (criterion == 3) { 
                System.out.println("Введите операционную систему:");
                String os = scanner.next();
                filters.put(criterion, os);
            }
        }
        // Произведем фильтрацию и выведем результат
        Set<ManyLaptops> filteredNotebooks = filterNotebooks(notebooks, filters);
        System.out.println("Отфильтрованные ноутбуки:");
        for (ManyLaptops notebook : filteredNotebooks) {
            System.out.println(notebook);
        }
    }

    // Метод фильтрации ноутбуков
    public static Set<ManyLaptops> filterNotebooks(Set<ManyLaptops> notebooks, Map<Integer, Object> filters) {
        Set<ManyLaptops> filteredNotebooks = new HashSet<>();
        for (ManyLaptops notebook : notebooks) {
            boolean passCriteria = true;
            for (Map.Entry<Integer, Object> entry : filters.entrySet()) {
                int criterion = entry.getKey();
                Object value = entry.getValue();
                if (criterion == 1) { // фильтрация по ОЗУ
                    if (notebook.getRam() < (int) value) {
                        passCriteria = false;
                        break;
                    }
                } else if (criterion == 2) { // фильтрация по объему жесткого диска
                    if (notebook.getStorage() < (int) value) {
                        passCriteria = false;
                        break;
                    }
                } else if (criterion == 3) { // фильтрация по операционной системе
                    if (!notebook.getOperatingSystem().equalsIgnoreCase((String) value)) {
                        passCriteria = false;
                        break;
                    }
                }
            }

            if (passCriteria) {
                filteredNotebooks.add(notebook);
            }
        }
        return filteredNotebooks;
    }
}

