import { ComplexBase } from '@syncfusion/ej2-react-base';
import { NodeModel } from '@syncfusion/ej2-diagrams';
/**
 * `NodesDirective` directive represent a nodes of the react diagram.
 * It must be contained in a Diagram component(`DiagramComponent`).
 * ```tsx
 * <DiagramComponent>
 * <NodesDirective>
 * <NodeDirective></NodeDirective>
 * </NodesDirective>
 * </DiagramComponent>
 * ```
 */
export declare class NodeDirective extends ComplexBase<NodeModel, NodeModel> {
    static moduleName: string;
}
export declare class NodesDirective extends ComplexBase<{}, {}> {
    static propertyName: string;
    static moduleName: string;
}
