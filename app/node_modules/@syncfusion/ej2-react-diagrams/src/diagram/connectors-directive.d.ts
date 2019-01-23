import { ComplexBase } from '@syncfusion/ej2-react-base';
import { ConnectorModel } from '@syncfusion/ej2-diagrams';
/**
 * `ConnectorsDirective` directive represent a connectors of the react diagram.
 * It must be contained in a Diagram component(`DiagramComponent`).
 * ```tsx
 * <DiagramComponent>
 * <ConnectorsDirective>
 * <ConnectorDirective></ConnectorDirective>
 * </ConnectorsDirective>
 * </DiagramComponent>
 * ```
 */
export declare class ConnectorDirective extends ComplexBase<ConnectorModel, ConnectorModel> {
    static moduleName: string;
}
export declare class ConnectorsDirective extends ComplexBase<{}, {}> {
    static propertyName: string;
    static moduleName: string;
}
