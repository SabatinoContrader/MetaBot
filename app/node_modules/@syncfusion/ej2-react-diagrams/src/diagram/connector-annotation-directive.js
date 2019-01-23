var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
        return extendStatics(d, b);
    }
    return function (d, b) {
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
import { ComplexBase } from '@syncfusion/ej2-react-base';
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
var ConnectorAnnotationDirective = /** @class */ (function (_super) {
    __extends(ConnectorAnnotationDirective, _super);
    function ConnectorAnnotationDirective() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    ConnectorAnnotationDirective.moduleName = 'connectorAnnotation';
    return ConnectorAnnotationDirective;
}(ComplexBase));
export { ConnectorAnnotationDirective };
var ConnectorAnnotationsDirective = /** @class */ (function (_super) {
    __extends(ConnectorAnnotationsDirective, _super);
    function ConnectorAnnotationsDirective() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    ConnectorAnnotationsDirective.propertyName = 'annotations';
    ConnectorAnnotationsDirective.moduleName = 'connectorAnnotations';
    return ConnectorAnnotationsDirective;
}(ComplexBase));
export { ConnectorAnnotationsDirective };
