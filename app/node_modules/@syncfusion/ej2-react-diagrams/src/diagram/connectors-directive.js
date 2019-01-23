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
var ConnectorDirective = /** @class */ (function (_super) {
    __extends(ConnectorDirective, _super);
    function ConnectorDirective() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    ConnectorDirective.moduleName = 'connector';
    return ConnectorDirective;
}(ComplexBase));
export { ConnectorDirective };
var ConnectorsDirective = /** @class */ (function (_super) {
    __extends(ConnectorsDirective, _super);
    function ConnectorsDirective() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    ConnectorsDirective.propertyName = 'connectors';
    ConnectorsDirective.moduleName = 'connectors';
    return ConnectorsDirective;
}(ComplexBase));
export { ConnectorsDirective };
