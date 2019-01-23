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
var NodeDirective = /** @class */ (function (_super) {
    __extends(NodeDirective, _super);
    function NodeDirective() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    NodeDirective.moduleName = 'node';
    return NodeDirective;
}(ComplexBase));
export { NodeDirective };
var NodesDirective = /** @class */ (function (_super) {
    __extends(NodesDirective, _super);
    function NodesDirective() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    NodesDirective.propertyName = 'nodes';
    NodesDirective.moduleName = 'nodes';
    return NodesDirective;
}(ComplexBase));
export { NodesDirective };
