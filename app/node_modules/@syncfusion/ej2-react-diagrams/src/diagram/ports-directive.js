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
var PortDirective = /** @class */ (function (_super) {
    __extends(PortDirective, _super);
    function PortDirective() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    PortDirective.moduleName = 'port';
    return PortDirective;
}(ComplexBase));
export { PortDirective };
var PortsDirective = /** @class */ (function (_super) {
    __extends(PortsDirective, _super);
    function PortsDirective() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    PortsDirective.propertyName = 'ports';
    PortsDirective.moduleName = 'ports';
    return PortsDirective;
}(ComplexBase));
export { PortsDirective };
