package org.example;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import java.io.Writer;
import java.util.Set;

@SupportedAnnotationTypes("org.example.GenerateReport")
@SupportedSourceVersion(SourceVersion.RELEASE_17)
public class ReportProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "Processing annotations...");

        for (Element element : roundEnv.getElementsAnnotatedWith(GenerateReport.class)) {
            String className = element.getSimpleName() + "Report";
            try {
                JavaFileObject file = processingEnv.getFiler().createSourceFile("org.example." + className);
                try (Writer writer = file.openWriter()) {
                    writer.write("package org.example;\n");
                    writer.write("public class " + className + " {\n");
                    writer.write("    public void generate() {\n");
                    writer.write("        System.out.println(\"Generating report for " + element.getSimpleName() + "\");\n");
                    writer.write("    }\n");
                    writer.write("}\n");
                }
                processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "Generated class: " + className);
            } catch (Exception e) {
                e.printStackTrace();
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "Failed to generate class: " + className);
            }
        }
        return true;
    }
}
