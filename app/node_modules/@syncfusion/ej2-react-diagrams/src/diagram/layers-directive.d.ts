import { ComplexBase } from '@syncfusion/ej2-react-base';
import { LayerModel } from '@syncfusion/ej2-diagrams';
/**
 * `Layers Directive` directive represent a connectors of the react diagram.
 * It must be contained in a Diagram component(`DiagramComponent`).
 * ```tsx
 * <DiagramComponent>
 * <LayersDirective>
 * <LayerDirective></LayerDirective>
 * </LayersDirective>
 * </DiagramComponent>
 * ```
 */
export declare class LayerDirective extends ComplexBase<LayerModel, LayerModel> {
    static moduleName: string;
}
export declare class LayersDirective extends ComplexBase<{}, {}> {
    static propertyName: string;
    static moduleName: string;
}
