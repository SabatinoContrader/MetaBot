import * as React from "react";
import {
  LayoutAnimation,
  HierarchicalTree,
  DataBinding,
  DiagramComponent,
  SnapConstraints,
  DiagramConstraints,
  Inject,
  DiagramTools
} from "@syncfusion/ej2-react-diagrams";
import { DataManager } from "@syncfusion/ej2-data";

export class HierarchicalModel extends React.PureComponent {
  constructor(props) {
    super(props);
    this.state = { hierarchicalTree: [] };
  }
  componentDidMount() {
    let result = this.props.hierarchicalTree.map(nodo => ({ idNodo: nodo.idNodo, text: nodo.text, nodoPadre: (nodo.nodoPadre==null ? "" : nodo.nodoPadre.idNodo) }));
    this.setState({hierarchicalTree: result});
  }

  render() {
    return (
      <div className="col-lg-12 control-section">
        <div className="content-wrapper" style={{ width: "100%" }}>
          <DiagramComponent
            id="diagram"
            ref={diagram => diagram}
            width={"100%"}
            height={"1000px"}
            snapSettings={{ constraints: SnapConstraints.None }} //configures data source settings
            constraints={DiagramConstraints.Bridging  }
            //scrollSettings={{  canAutoScroll: true}}
            dataSourceSettings={{
              //sets the fields to bind
              id: "idNodo",
              parentId: "nodoPadre",
              dataManager: new DataManager(this.state.hierarchicalTree), //Lista
              doBinding: (nodeModel, data, diagram) => {
                nodeModel.shape = {
                  type: "Text",
                  content: data.text
                };
              }
            }} //Disables all interactions except zoom/pan
            tool={DiagramTools.ZoomPan} //Configures automatic layout
            layout={{
              type: "HierarchicalTree",
              verticalSpacing: 50,
              horizontalSpacing: 50,
              //enableAnimation: true
            }} //Defines the default node and connector properties
            getNodeDefaults={(obj, diagram) => {
              return nodeDefaults(obj, diagram);
            }}
            getConnectorDefaults={(connector, diagram) => {
              return connectorDefaults(connector, diagram);
            }}
          >
            <Inject
              services={[DataBinding, HierarchicalTree, LayoutAnimation]}
            />
          </DiagramComponent>
        </div>
      </div>
    );
  }
}
//sets node default value
function nodeDefaults(obj, diagram) {
  obj.style = {
    fill: "#659be5",
    strokeColor: "none",
    color: "white",
    strokeWidth: 2
  };
  obj.borderColor = "#3a6eb5";
  obj.backgroundColor = "#659be5";
  obj.shape.margin = { left: 5, right: 5, bottom: 5, top: 5 };
  obj.expandIcon = {
    height: 10,
    width: 10,
    shape: "None",
    fill: "lightgray",
    offset: { x: 0.5, y: 1 }
  };
  obj.expandIcon.verticalAlignment = "Auto";
  obj.expandIcon.margin = { left: 0, right: 0, top: 0, bottom: 0 };
  obj.collapseIcon.offset = { x: 0.5, y: 1 };
  obj.collapseIcon.verticalAlignment = "Auto";
  obj.collapseIcon.margin = { left: 0, right: 0, top: 0, bottom: 0 };
  obj.collapseIcon.height = 10;
  obj.collapseIcon.width = 10;
  obj.collapseIcon.padding.top = 5;
  obj.collapseIcon.shape = "None";
  obj.collapseIcon.fill = "lightgray";
  return obj;
}
//sets connector default value
function connectorDefaults(connector, diagram) {
  connector.targetDecorator.shape = "None";
  connector.type = "Orthogonal";
  connector.style.strokeColor = "#6d6d6d";
  connector.constraints = 0;
  connector.cornerRadius = 5;
  return connector;
}
export default HierarchicalModel;
