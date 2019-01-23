import { ComplexBase } from '@syncfusion/ej2-react-base';
import { PathAnnotationModel } from '@syncfusion/ej2-diagrams';
/**
 * `Annotation` directive represent a annotation of the react Diagram.
 * It must be contained in a Diagram component(`DiagramComponent`).
 * ```tsx
 * <DiagramComponent>
 * <ConnectorsDirective>
 * <ConnectorDirective>
 * <ConnectorAnnotationsDirective>
 * <ConnectorAnnotationDirective>
 * </ConnectorAnnotationDirective>
 * </ConnectorAnnotationsDirective>
 * </ConnectorDirective>
 * </ConnectorsDirective>
 * </DiagramComponent>
 * ```
 */
export declare class ConnectorAnnotationDirective extends ComplexBase<PathAnnotationModel, PathAnnotationModel> {
    static moduleName: string;
}
export declare class ConnectorAnnotationsDirective extends ComplexBase<{}, {}> {
    static propertyName: string;
    static moduleName: string;
}
