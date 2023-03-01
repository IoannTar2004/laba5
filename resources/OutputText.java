package resources;

public class OutputText {
    public static void startInformation(String info) {
        switch (info) {
            case "CorrectXmlFile" -> System.out.println("Данная программа работает с коллекции типа ArrayDeque. " +
                    "Cчитывает и записывает данные в xml файл. " +
                    "Вывести пример правильного xml-файла? (y - да, n - нет)");

            case "Example" ->  System.out.println("<root>\n" +
                    "\t<object id = \"274726478289\">\n" +
                    "\t\t<name>Ivan</name>\n" +
                    "\t\t<coordinates>55; 746</coordinates>\n" +
                    "\t\t<age>3</age>\n" +
                    "\t\t<color>Чёрный</color>\n" +
                    "\t\t<type>Воздушный</type>\n" +
                    "\t\t<character>Злой</character>\n" +
                    "\t\t<cavedepth>3.04</cavedepth>\n" +
                    "\t</object>\n" +
                    "</root>\n");

            case "EnvVar" -> System.out.println("Имена файлов, с которыми работает эта программа, " +
                    "передаются ей через переменную окружения." +
                    "Введите название переменной, значение которой содержит полный путь до xml-файла.");

            case "ReadFile" -> System.out.println("Считать данные из файла? (y - да, n - нет)");

            case "ProgramReady" -> System.out.println("\nПрограмма готова к работе. " +
                    "Введите команду help, чтобы посмотреть все команды.\n");

            case "yes_no" -> System.out.println("(y - да, n - нет)");

        }
    }

    public static void error(String error) {
        switch (error) {
            case "FileNotFound" ->  System.out.println("Файл не найден! Проверьте путь до файла или его права.");

            case "EmptyName" -> System.out.println("Имя не может быть пустым!");
        }
    }
}
