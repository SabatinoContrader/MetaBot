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
var NodeAnnotationDirective = /** @class */ (function (_super) {
    __extends(NodeAnnotationDirective, _super);
    function NodeAnnotationDirective() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    NodeAnnotationDirective.moduleName = 'nodeAnnotation';
    return NodeAnnotationDirective;
}(ComplexBase));
export { NodeAnnotationDirective };
var NodeAnnotationsDirective = /** @class */ (function (_super) {
    __extends(NodeAnnotationsDirective, _super);
    function NodeAnnotationsDirective() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    NodeAnnotationsDirective.propertyName = 'annotations';
    NodeAnnotationsDirective.moduleName = 'nodeAnnotations';
    return NodeAnnotationsDirective;
}(ComplexBase));
export { NodeAnnotationsDirective };
