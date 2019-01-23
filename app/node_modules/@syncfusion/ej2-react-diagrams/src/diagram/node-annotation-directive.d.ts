import { ComplexBase } from '@syncfusion/ej2-react-base';
import { ShapeAnnotationModel } from '@syncfusion/ej2-diagrams';
/**
 * `Node` directive represent a annotation of the react Diagram.
 * It must be contained in a Diagram component(`DiagramComponent`).
 * ```tsx
 * <DiagramComponent>
 * <NodesDirective>
 * <NodeDirective>
 * <NodeAnnotationsDirective>
 * <NodeAnnotationDirective>
 * </NodeAnnotationDirective>
 * </NodeAnnotationsDirective>
 * </NodeDirective>
 * </NodesDirective>
 * </DiagramComponent>
 * ```
 */
export declare class NodeAnnotationDirective extends ComplexBase<ShapeAnnotationModel, ShapeAnnotationModel> {
    static moduleName: string;
}
export declare class NodeAnnotationsDirective extends ComplexBase<{}, {}> {
    static propertyName: string;
    static moduleName: string;
}
