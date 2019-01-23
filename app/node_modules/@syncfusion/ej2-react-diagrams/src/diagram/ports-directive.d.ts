import { ComplexBase } from '@syncfusion/ej2-react-base';
import { PointPortModel } from '@syncfusion/ej2-diagrams';
/**
 * `Node` directive represent a port of the react Diagram.
 * It must be contained in a Diagram component(`DiagramComponent`).
 * ```tsx
 * <DiagramComponent>
 * <NodesDirective>
 * <NodeDirective>
 * <PortCollectionDirective>
 * <PortDirective>
 * </PortDirective>
 * </PortCollectionDirective>
 * </NodeDirective>
 * </NodesDirective>
 * </DiagramComponent>
 * ```
 */
export declare class PortDirective extends ComplexBase<PointPortModel, PointPortModel> {
    static moduleName: string;
}
export declare class PortsDirective extends ComplexBase<{}, {}> {
    static propertyName: string;
    static moduleName: string;
}
