package src.tools;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import src.support.IdChecker;
import src.support.Checks;
import src.collectionClasses.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class XMLReader {
    /**
     * Reads initial xml file during {@link ProgramStart#start() programm start}. Method can print mistakes pointing to the object.
     * @param xml xml file
     */
    public static void parse(File xml) {
        boolean start = true;

        DocumentBuilderFactory dbfact = DocumentBuilderFactory.newInstance();
        Document document = null;
        try {
            DocumentBuilder dbuilder = dbfact.newDocumentBuilder();
            document = dbuilder.parse(xml);
        } catch (SAXException | ParserConfigurationException e) {
            System.out.println("XML-файл не валиден! Проверьте теги!");
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Файл куда-то пропал или были изменены его права!");
            System.exit(0);
        }
        NodeList nodeList = document.getElementsByTagName("object");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node obj = nodeList.item(i);
            Element element = (Element) obj;
            boolean create = true;
            String error = " - ошибка в \"object id: " + element.getAttribute("id") + "\"";

            Long id = IdChecker.check(element.getAttribute("id"));
            if (id == -1) {
                System.out.println(error);
                create = false;
                start = false;
            } else {
                Dragon dragon = CollectionManager.getDragonById(id);
                if (dragon != null) {
                    System.out.println("Объект с id: \"" + element.getAttribute("id") + "\" уже существует");
                    create = false;
                    start = false;
                }
            }

            String name = null;
            try {
                name = Checks.nameCheck(element.getElementsByTagName("name").item(0).getTextContent());
                if (name == null) {
                    System.out.println("Имя не может быть пустым!" + error);
                    create = false;
                    start = false;
                }
            } catch (NullPointerException e) {
                System.out.println("Отсутствует тег <name>"+error);
                create = false;
                start = false;
            }

            Coordinates coordinates = null;
            try {
                coordinates = Checks.coordinatesChecker(element.getElementsByTagName("coordinates").item(0).getTextContent());
                if (coordinates == null) {
                    System.out.println("Координаты должны быть записаны в виде двух чисел через пробел или точку с запятой" +
                            error);
                    create = false;
                    start = false;
                }
            } catch (NullPointerException e) {
                System.out.println("Отсутствует тег <coordinates>"+error);
                create = false;
                start = false;
            }

            int age = -1;
            try {
                age = Checks.ageChecker(element.getElementsByTagName("age").item(0).getTextContent());
                if (age == -1) {
                    System.out.println("Возраст должен быть целым положительным числом!" + error);
                    create = false;
                    start = false;
                }
            } catch (NullPointerException e) {
                System.out.println("Отсутствует тег <age>"+error);
                create = false;
                start = false;
            }


            Color color = null;
            try {
                color = Color.getEnumColor(element.getElementsByTagName("color").item(0).getTextContent());
                if (color == null) {
                    System.out.println("Такого цвета нет!"+error);
                    create = false;
                    start = false;
                }
            } catch (NullPointerException e) {
                System.out.println("Отсутствует тег <color>"+error);
                create = false;
                start = false;
            }

            DragonType type = null;
            try {
                type = DragonType.getEnumType(element.getElementsByTagName("type").item(0).getTextContent());
                if (type == null) {
                    System.out.println("Такого типа нет!"+error);
                    create = false;
                    start = false;
                }
            } catch (NullPointerException e) {
                System.out.println("Отсутствует тег <type>"+error);
                create = false;
                start = false;
            }

            DragonCharacter character = null;
            try {
                character = DragonCharacter.getEnumCharacter(element.getElementsByTagName("character").item(0).getTextContent());
                if (character == null) {
                    System.out.println("Такого характера нет!"+error);
                    create = false;
                    start = false;
                }
            } catch (NullPointerException e) {
                System.out.println("Отсутствует тег <character>"+error);
                create = false;
                start = false;
            }

            DragonCave cave = null;
            try {
                cave = Checks.caveChecker(element.getElementsByTagName("cavedepth").item(0).getTextContent());
                if (cave == null) {
                    System.out.println("Глубина пещеры должна быть записана в виде дробного числа через точку!" + error);
                    create = false;
                    start = false;
                }
            } catch (NullPointerException e) {
                System.out.println("Отсутствует тег <cavedepth>"+error);
                create = false;
                start = false;
            }

            if (create) {
                Dragon dragon = new Dragon(id, name, coordinates, age, color, type, character, cave, new Date());
                CollectionManager.add(dragon);
            }
        }
        if (!start) {
            System.exit(0);
        }
    }
}
