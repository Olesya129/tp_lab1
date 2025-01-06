import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

public class ValidatorMain {
    // Метод для проверки валидности XML-файла с использованием XSD-схемы
    public static boolean validateXML(String xmlPath, String xsdPath) {
        try {
            // Создаем фабрику для работы с XSD-схемами. Используется стандарт W3C XML Schema
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

            // Загружаем XSD-схему из файла (определяем структуру и правила для XML-документа)
            Schema schema = factory.newSchema(new File(xsdPath));

            // Создаем валидатор для проверки XML-файла на соответствие указанной XSD-схеме
            Validator validator = schema.newValidator();

            // Выполняем валидацию XML-файла
            // Если файл не соответствует схеме, выбрасывается исключение
            validator.validate(new StreamSource(new File(xmlPath)));

            // Если исключение не возникло, выводим сообщение об успешной валидации
            System.out.println("\nВалидация успешно пройдена");
            return true;
        } catch (Exception e) {
            // Если возникла ошибка, выводим сообщение об ошибке и ее причину
            System.out.println("\nВалидация не пройдена: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
