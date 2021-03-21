package concepts.annotations;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Messager;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import javax.tools.Diagnostic;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DateFormatProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment env) {
        Messager messager = processingEnv.getMessager();
        for (TypeElement typeElement : annotations) {
            for (Element element : env.getElementsAnnotatedWith(typeElement)) {
                DateFormat annotation = element.getAnnotation(DateFormat.class);
                TypeMirror typeMirror = element.asType();

                //checking the filed type
                //we don't have field class type information as code is not yet built
                //so we have to compare the strings
                if (!typeMirror.toString().equals(LocalDate.class.getName())) {
                    messager.printMessage(Diagnostic.Kind.ERROR,
                            "The type annotated with @DateFormat must be LocalDate");
                }

                try {
                    //validating date format
                    DateTimeFormatter simpleDateFormat =
                            DateTimeFormatter.ofPattern(annotation.value());
                    LocalDate.now().format(simpleDateFormat);

                } catch (Exception e) {
                    messager.printMessage(Diagnostic.Kind.ERROR,
                            "Not a valid date format " + annotation.value());
                }
            }
        }
        return false;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return new HashSet<>(Arrays.asList(DateFormat.class.getName()));
    }
}
