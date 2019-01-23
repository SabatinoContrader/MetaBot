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
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
import { Component, isUndefined, Browser, compile } from '@syncfusion/ej2-base';
import { Property, NotifyPropertyChanges, ChildProperty, Complex } from '@syncfusion/ej2-base';
import { Event, EventHandler, KeyboardEvents } from '@syncfusion/ej2-base';
import { rippleEffect, Animation } from '@syncfusion/ej2-base';
import { Draggable, Droppable } from '@syncfusion/ej2-base';
import { addClass, removeClass, closest, matches, detach, select, selectAll, isVisible, append } from '@syncfusion/ej2-base';
import { DataManager, Query } from '@syncfusion/ej2-data';
import { isNullOrUndefined as isNOU, Touch, getValue, setValue } from '@syncfusion/ej2-base';
import { ListBase } from '@syncfusion/ej2-lists';
import { createCheckBox, rippleMouseHandler } from '@syncfusion/ej2-buttons';
import { Input } from '@syncfusion/ej2-inputs';
import { createSpinner, showSpinner, hideSpinner } from '@syncfusion/ej2-popups';
var ROOT = 'e-treeview';
var CONTROL = 'e-control';
var COLLAPSIBLE = 'e-icon-collapsible';
var EXPANDABLE = 'e-icon-expandable';
var LISTITEM = 'e-list-item';
var LISTTEXT = 'e-list-text';
var PARENTITEM = 'e-list-parent';
var HOVER = 'e-hover';
var ACTIVE = 'e-active';
var LOAD = 'e-icons-spinner';
var PROCESS = 'e-process';
var ICON = 'e-icons';
var TEXTWRAP = 'e-text-content';
var INPUT = 'e-input';
var INPUTGROUP = 'e-input-group';
var TREEINPUT = 'e-tree-input';
var EDITING = 'e-editing';
var RTL = 'e-rtl';
var DRAGITEM = 'e-drag-item';
var DROPPABLE = 'e-droppable';
var DRAGGING = 'e-dragging';
var SIBLING = 'e-sibling';
var DROPIN = 'e-drop-in';
var DROPNEXT = 'e-drop-next';
var DROPOUT = 'e-drop-out';
var NODROP = 'e-no-drop';
var FULLROWWRAP = 'e-fullrow-wrap';
var FULLROW = 'e-fullrow';
var SELECTED = 'e-selected';
var EXPANDED = 'e-expanded';
var NODECOLLAPSED = 'e-node-collapsed';
var DISABLE = 'e-disable';
var CONTENT = 'e-content';
var DOWNTAIL = 'e-downtail';
var DROPCOUNT = 'e-drop-count';
var CHECK = 'e-check';
var INDETERMINATE = 'e-stop';
var CHECKBOXWRAP = 'e-checkbox-wrapper';
var CHECKBOXFRAME = 'e-frame';
var CHECKBOXRIPPLE = 'e-ripple-container';
var FOCUS = 'e-node-focus';
var IMAGE = 'e-list-img';
var BIGGER = 'e-bigger';
var SMALL = 'e-small';
var treeAriaAttr = {
    treeRole: 'tree',
    itemRole: 'treeitem',
    listRole: 'group',
    itemText: '',
    wrapperRole: '',
};
/**
 * Configures the fields to bind to the properties of node in the TreeView component.
 */
var FieldsSettings = /** @class */ (function (_super) {
    __extends(FieldsSettings, _super);
    function FieldsSettings() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    __decorate([
        Property('child')
    ], FieldsSettings.prototype, "child", void 0);
    __decorate([
        Property([])
    ], FieldsSettings.prototype, "dataSource", void 0);
    __decorate([
        Property('expanded')
    ], FieldsSettings.prototype, "expanded", void 0);
    __decorate([
        Property('hasChildren')
    ], FieldsSettings.prototype, "hasChildren", void 0);
    __decorate([
        Property('htmlAttributes')
    ], FieldsSettings.prototype, "htmlAttributes", void 0);
    __decorate([
        Property('iconCss')
    ], FieldsSettings.prototype, "iconCss", void 0);
    __decorate([
        Property('id')
    ], FieldsSettings.prototype, "id", void 0);
    __decorate([
        Property('imageUrl')
    ], FieldsSettings.prototype, "imageUrl", void 0);
    __decorate([
        Property('isChecked')
    ], FieldsSettings.prototype, "isChecked", void 0);
    __decorate([
        Property('parentID')
    ], FieldsSettings.prototype, "parentID", void 0);
    __decorate([
        Property(null)
    ], FieldsSettings.prototype, "query", void 0);
    __decorate([
        Property('selected')
    ], FieldsSettings.prototype, "selected", void 0);
    __decorate([
        Property(null)
    ], FieldsSettings.prototype, "tableName", void 0);
    __decorate([
        Property('text')
    ], FieldsSettings.prototype, "text", void 0);
    __decorate([
        Property('tooltip')
    ], FieldsSettings.prototype, "tooltip", void 0);
    __decorate([
        Property('navigateUrl')
    ], FieldsSettings.prototype, "navigateUrl", void 0);
    return FieldsSettings;
}(ChildProperty));
export { FieldsSettings };
/**
 * Configures animation settings for the TreeView component.
 */
var ActionSettings = /** @class */ (function (_super) {
    __extends(ActionSettings, _super);
    function ActionSettings() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    __decorate([
        Property('SlideDown')
    ], ActionSettings.prototype, "effect", void 0);
    __decorate([
        Property(400)
    ], ActionSettings.prototype, "duration", void 0);
    __decorate([
        Property('linear')
    ], ActionSettings.prototype, "easing", void 0);
    return ActionSettings;
}(ChildProperty));
export { ActionSettings };
/**
 * Configures the animation settings for expanding and collapsing nodes in TreeView.
 */
var NodeAnimationSettings = /** @class */ (function (_super) {
    __extends(NodeAnimationSettings, _super);
    function NodeAnimationSettings() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    __decorate([
        Complex({ effect: 'SlideUp', duration: 400, easing: 'linear' }, ActionSettings)
    ], NodeAnimationSettings.prototype, "collapse", void 0);
    __decorate([
        Complex({ effect: 'SlideDown', duration: 400, easing: 'linear' }, ActionSettings)
    ], NodeAnimationSettings.prototype, "expand", void 0);
    return NodeAnimationSettings;
}(ChildProperty));
export { NodeAnimationSettings };
/**
 * The TreeView component is used to represent hierarchical data in a tree like structure with advanced
 * functions to perform edit, drag and drop, selection with check-box, and more.
 * ```html
 *  <div id="tree"></div>
 * ```
 * ```typescript
 *  let treeObj: TreeView = new TreeView();
 *  treeObj.appendTo('#tree');
 * ```
 */
var TreeView = /** @class */ (function (_super) {
    __extends(TreeView, _super);
    function TreeView(options, element) {
        var _this = _super.call(this, options, element) || this;
        _this.preventExpand = false;
        _this.checkedElement = [];
        _this.disableNode = [];
        _this.mouseDownStatus = false;
        return _this;
    }
    TreeView_1 = TreeView;
    /**
     * Get component name.
     * @returns string
     * @private
     */
    TreeView.prototype.getModuleName = function () {
        return 'treeview';
    };
    /**
     * Initialize the event handler
     */
    TreeView.prototype.preRender = function () {
        var _this = this;
        this.checkActionNodes = [];
        this.dragStartAction = false;
        this.isAnimate = false;
        this.keyConfigs = {
            escape: 'escape',
            end: 'end',
            enter: 'enter',
            f2: 'f2',
            home: 'home',
            moveDown: 'downarrow',
            moveLeft: 'leftarrow',
            moveRight: 'rightarrow',
            moveUp: 'uparrow',
            ctrlDown: 'ctrl+downarrow',
            ctrlUp: 'ctrl+uparrow',
            ctrlEnter: 'ctrl+enter',
            ctrlHome: 'ctrl+home',
            ctrlEnd: 'ctrl+end',
            ctrlA: 'ctrl+A',
            shiftDown: 'shift+downarrow',
            shiftUp: 'shift+uparrow',
            shiftEnter: 'shift+enter',
            shiftHome: 'shift+home',
            shiftEnd: 'shift+end',
            csDown: 'ctrl+shift+downarrow',
            csUp: 'ctrl+shift+uparrow',
            csEnter: 'ctrl+shift+enter',
            csHome: 'ctrl+shift+home',
            csEnd: 'ctrl+shift+end',
            space: 'space',
        };
        this.listBaseOption = {
            expandCollapse: true,
            showIcon: true,
            expandIconClass: EXPANDABLE,
            ariaAttributes: treeAriaAttr,
            expandIconPosition: 'Left',
            itemCreated: function (e) {
                _this.beforeNodeCreate(e);
            },
        };
        this.updateListProp(this.fields);
        this.aniObj = new Animation({});
        this.treeList = [];
        this.isLoaded = false;
        this.isInitalExpand = false;
        this.index = 0;
        this.setTouchClass();
        if (isNOU(this.selectedNodes)) {
            this.setProperties({ selectedNodes: [] }, true);
        }
        if (isNOU(this.checkedNodes)) {
            this.setProperties({ checkedNodes: [] }, true);
        }
        if (isNOU(this.expandedNodes)) {
            this.setProperties({ expandedNodes: [] }, true);
        }
        else {
            this.isInitalExpand = true;
        }
    };
    /**
     * Get the properties to be maintained in the persisted state.
     * @returns string
     * @hidden
     */
    TreeView.prototype.getPersistData = function () {
        var keyEntity = ['selectedNodes', 'checkedNodes', 'expandedNodes'];
        return this.addOnPersist(keyEntity);
    };
    /**
     * To Initialize the control rendering
     * @private
     */
    TreeView.prototype.render = function () {
        this.initialRender = true;
        this.initialize();
        this.setDataBinding();
        this.setExpandOnType();
        this.setRipple();
        this.wireEditingEvents(this.allowEditing);
        this.setDragAndDrop(this.allowDragAndDrop);
        this.wireEvents();
        this.initialRender = false;
    };
    TreeView.prototype.initialize = function () {
        this.element.setAttribute('role', 'tree');
        this.element.setAttribute('tabindex', '0');
        this.element.setAttribute('aria-activedescendant', this.element.id + '_active');
        this.setCssClass(null, this.cssClass);
        this.setEnableRtl();
        this.setFullRow(this.fullRowSelect);
        this.nodeTemplateFn = this.templateComplier(this.nodeTemplate);
    };
    TreeView.prototype.setEnableRtl = function () {
        this.enableRtl ? addClass([this.element], RTL) : removeClass([this.element], RTL);
    };
    TreeView.prototype.setRipple = function () {
        var tempStr = '.' + FULLROW + ',.' + TEXTWRAP;
        var rippleModel = {
            selector: tempStr,
            ignore: '.' + TEXTWRAP + ' > .' + ICON + ',.' + INPUTGROUP + ',.' + INPUT + ', .' + CHECKBOXWRAP
        };
        this.rippleFn = rippleEffect(this.element, rippleModel);
        var iconModel = {
            selector: '.' + TEXTWRAP + ' > .' + ICON,
            isCenterRipple: true,
        };
        this.rippleIconFn = rippleEffect(this.element, iconModel);
    };
    TreeView.prototype.setFullRow = function (isEnabled) {
        isEnabled ? addClass([this.element], FULLROWWRAP) : removeClass([this.element], FULLROWWRAP);
    };
    TreeView.prototype.setMultiSelect = function (isEnabled) {
        var firstUl = select('.' + PARENTITEM, this.element);
        if (isEnabled) {
            firstUl.setAttribute('aria-multiselectable', 'true');
        }
        else {
            firstUl.removeAttribute('aria-multiselectable');
        }
    };
    TreeView.prototype.templateComplier = function (template) {
        if (template) {
            var e = void 0;
            try {
                if (document.querySelectorAll(template).length) {
                    return compile(document.querySelector(template).innerHTML.trim());
                }
            }
            catch (e) {
                return compile(template);
            }
        }
        return undefined;
    };
    TreeView.prototype.setDataBinding = function () {
        var _this = this;
        this.treeList.push('false');
        if (this.fields.dataSource instanceof DataManager) {
            if (this.fields.dataSource.ready) {
                this.fields.dataSource.ready.then(function (e) {
                    if (_this.fields.dataSource instanceof DataManager && _this.fields.dataSource.dataSource.offline) {
                        _this.treeList.pop();
                        _this.treeData = e.result;
                        _this.isNumberTypeId = _this.getType();
                        _this.setRootData();
                        _this.renderItems(true);
                        if (_this.treeList.length === 0 && !_this.isLoaded) {
                            _this.finalize();
                        }
                    }
                });
            }
            else {
                this.fields.dataSource.executeQuery(this.getQuery(this.fields)).then(function (e) {
                    _this.treeList.pop();
                    _this.treeData = e.result;
                    _this.isNumberTypeId = _this.getType();
                    _this.setRootData();
                    _this.renderItems(true);
                    if (_this.treeList.length === 0 && !_this.isLoaded) {
                        _this.finalize();
                    }
                });
            }
        }
        else {
            this.treeList.pop();
            if (isNOU(this.fields.dataSource)) {
                this.rootData = this.treeData = [];
            }
            else {
                this.treeData = JSON.parse(JSON.stringify(this.fields.dataSource));
                this.setRootData();
            }
            this.isNumberTypeId = this.getType();
            this.renderItems(false);
        }
        if (this.treeList.length === 0 && !this.isLoaded) {
            this.finalize();
        }
    };
    TreeView.prototype.getQuery = function (mapper, value) {
        if (value === void 0) { value = null; }
        var columns = [];
        var query;
        if (!mapper.query) {
            query = new Query();
            var prop = this.getActualProperties(mapper);
            for (var _i = 0, _a = Object.keys(prop); _i < _a.length; _i++) {
                var col = _a[_i];
                if (col !== 'dataSource' && col !== 'tableName' && col !== 'child' && !!mapper[col]
                    && columns.indexOf(mapper[col]) === -1) {
                    columns.push(mapper[col]);
                }
            }
            query.select(columns);
            if (prop.hasOwnProperty('tableName')) {
                query.from(mapper.tableName);
            }
        }
        else {
            query = mapper.query.clone();
        }
        ListBase.addSorting(this.sortOrder, mapper.text, query);
        if (!isNOU(value) && !isNOU(mapper.parentID)) {
            query.where(mapper.parentID, 'equal', (this.isNumberTypeId ? parseFloat(value) : value));
        }
        return query;
    };
    TreeView.prototype.getType = function () {
        return this.treeData[0] ? ((typeof getValue(this.fields.id, this.treeData[0]) === 'number') ? true : false) : false;
    };
    TreeView.prototype.setRootData = function () {
        this.dataType = this.getDataType(this.treeData, this.fields);
        if (this.dataType === 1) {
            this.groupedData = this.getGroupedData(this.treeData, this.fields.parentID);
            var rootItems = this.getChildNodes(this.treeData, undefined, true);
            if (isNOU(rootItems)) {
                this.rootData = [];
            }
            else {
                this.rootData = rootItems;
            }
        }
        else {
            this.rootData = this.treeData;
        }
    };
    TreeView.prototype.renderItems = function (isSorted) {
        this.listBaseOption.ariaAttributes.level = 1;
        this.ulElement = ListBase.createList(this.createElement, isSorted ? this.rootData : this.getSortedData(this.rootData), this.listBaseOption);
        this.element.appendChild(this.ulElement);
        if (this.loadOnDemand === false) {
            var rootNodes = this.ulElement.querySelectorAll('.e-list-item');
            var i = 0;
            while (i < rootNodes.length) {
                this.renderChildNodes(rootNodes[i], true, null, true);
                i++;
            }
        }
        else {
            this.finalizeNode(this.element);
        }
    };
    TreeView.prototype.beforeNodeCreate = function (e) {
        if (this.showCheckBox) {
            var checkboxEle = createCheckBox(this.createElement, true, { cssClass: this.touchClass });
            var icon = select('div.' + ICON, e.item);
            var id = e.item.getAttribute('data-uid');
            e.item.childNodes[0].insertBefore(checkboxEle, e.item.childNodes[0].childNodes[isNOU(icon) ? 0 : 1]);
            var checkValue = getValue(e.fields.isChecked, e.curData);
            if (this.checkedNodes.indexOf(id) > -1) {
                select('.' + CHECKBOXFRAME, checkboxEle).classList.add(CHECK);
                checkboxEle.setAttribute('aria-checked', 'true');
                this.addCheck(e.item);
            }
            else if (!isNOU(checkValue) && checkValue.toString() === 'true') {
                select('.' + CHECKBOXFRAME, checkboxEle).classList.add(CHECK);
                checkboxEle.setAttribute('aria-checked', 'true');
                this.addCheck(e.item);
            }
            else {
                checkboxEle.setAttribute('aria-checked', 'false');
            }
            var frame = select('.' + CHECKBOXFRAME, checkboxEle);
            EventHandler.add(frame, 'mousedown', this.frameMouseHandler, this);
            EventHandler.add(frame, 'mouseup', this.frameMouseHandler, this);
        }
        if (this.fullRowSelect) {
            this.createFullRow(e.item);
        }
        if (this.allowMultiSelection && !e.item.classList.contains(SELECTED)) {
            e.item.setAttribute('aria-selected', 'false');
        }
        var fields = e.fields;
        this.addActionClass(e, fields.selected, SELECTED);
        this.addActionClass(e, fields.expanded, EXPANDED);
        if (!isNOU(this.nodeTemplateFn)) {
            var textEle = e.item.querySelector('.' + LISTTEXT);
            textEle.innerHTML = '';
            append(this.nodeTemplateFn(e.curData), textEle);
        }
        var eventArgs = {
            node: e.item,
            nodeData: e.curData,
            text: e.text,
        };
        this.trigger('drawNode', eventArgs);
    };
    TreeView.prototype.frameMouseHandler = function (e) {
        var rippleSpan = select('.' + CHECKBOXRIPPLE, e.target.parentElement);
        rippleMouseHandler(e, rippleSpan);
    };
    TreeView.prototype.addActionClass = function (e, action, cssClass) {
        var data = e.curData;
        var actionValue = getValue(action, data);
        if (!isNOU(actionValue) && actionValue.toString() !== 'false') {
            e.item.classList.add(cssClass);
        }
    };
    TreeView.prototype.getDataType = function (ds, mapper) {
        if (this.fields.dataSource instanceof DataManager) {
            for (var i = 0; i < ds.length; i++) {
                if ((typeof mapper.child === 'string') && isNOU(getValue(mapper.child, ds[i]))) {
                    return 1;
                }
            }
            return 2;
        }
        for (var i = 0, len = ds.length; i < len; i++) {
            if ((typeof mapper.child === 'string') && !isNOU(getValue(mapper.child, ds[i]))) {
                return 2;
            }
            if (!isNOU(getValue(mapper.parentID, ds[i])) || !isNOU(getValue(mapper.hasChildren, ds[i]))) {
                return 1;
            }
        }
        return 1;
    };
    TreeView.prototype.getGroupedData = function (dataSource, groupBy) {
        var cusQuery = new Query().group(groupBy);
        var ds = ListBase.getDataSource(dataSource, cusQuery);
        var grpItem = [];
        for (var j = 0; j < ds.length; j++) {
            var itemObj = ds[j].items;
            grpItem.push(itemObj);
        }
        return grpItem;
    };
    TreeView.prototype.getSortedData = function (list) {
        if (list && this.sortOrder !== 'None') {
            list = ListBase.getDataSource(list, ListBase.addSorting(this.sortOrder, this.fields.text));
        }
        return list;
    };
    TreeView.prototype.finalizeNode = function (element) {
        var iNodes = selectAll('.' + IMAGE, element);
        for (var k = 0; k < iNodes.length; k++) {
            iNodes[k].setAttribute('alt', IMAGE);
        }
        if (this.isLoaded) {
            var sNodes = selectAll('.' + SELECTED, element);
            for (var i = 0; i < sNodes.length; i++) {
                this.selectNode(sNodes[i], null);
                break;
            }
            removeClass(sNodes, SELECTED);
        }
        var cNodes = selectAll('.' + LISTITEM + ':not(.' + EXPANDED + ')', element);
        for (var j = 0; j < cNodes.length; j++) {
            var icon = select('div.' + ICON, cNodes[j]);
            if (icon && icon.classList.contains(EXPANDABLE)) {
                this.disableExpandAttr(cNodes[j]);
            }
        }
        var eNodes = selectAll('.' + EXPANDED, element);
        if (!this.isInitalExpand) {
            for (var i = 0; i < eNodes.length; i++) {
                this.renderChildNodes(eNodes[i]);
            }
        }
        removeClass(eNodes, EXPANDED);
        this.updateList();
        if (this.isLoaded) {
            this.updateCheckedProp();
        }
    };
    TreeView.prototype.updateCheckedProp = function () {
        var _this = this;
        if (this.showCheckBox) {
            var nodes_1 = [].concat([], this.checkedNodes);
            this.checkedNodes.forEach(function (value, index) {
                var checkBox = _this.element.querySelector('[data-uid="' + value + '"]');
                if (isNOU(checkBox)) {
                    nodes_1 = nodes_1.filter(function (e) { return e !== value; });
                }
            });
            this.setProperties({ checkedNodes: nodes_1 }, true);
        }
    };
    TreeView.prototype.ensureIndeterminate = function () {
        if (this.autoCheck) {
            var liElement = selectAll('li', this.element);
            var ulElement = void 0;
            for (var i = 0; i < liElement.length; i++) {
                if (liElement[i].classList.contains(LISTITEM)) {
                    ulElement = select('.' + PARENTITEM, liElement[i]);
                    if (ulElement) {
                        this.ensureParentCheckState(liElement[i]);
                    }
                    else {
                        this.ensureChildCheckState(liElement[i]);
                    }
                }
            }
        }
        else {
            var indeterminate = selectAll('.' + INDETERMINATE, this.element);
            for (var i = 0; i < indeterminate.length; i++) {
                indeterminate[i].classList.remove(INDETERMINATE);
            }
        }
    };
    TreeView.prototype.ensureParentCheckState = function (element) {
        if (!isNOU(element)) {
            if (element.classList.contains(ROOT)) {
                return;
            }
            var ulElement = element;
            if (element.classList.contains(LISTITEM)) {
                ulElement = select('.' + PARENTITEM, element);
            }
            var checkedNodes = selectAll('.' + CHECK, ulElement);
            var nodes = selectAll('.' + LISTITEM, ulElement);
            var checkBoxEle = element.getElementsByClassName(CHECKBOXWRAP)[0];
            if (nodes.length === checkedNodes.length) {
                this.changeState(checkBoxEle, 'check', null, true, true);
            }
            else if (checkedNodes.length > 0) {
                this.changeState(checkBoxEle, 'indeterminate', null, true, true);
            }
            else if (checkedNodes.length === 0) {
                this.changeState(checkBoxEle, 'uncheck', null, true, true);
            }
            var parentUL = closest(element, '.' + PARENTITEM);
            if (!isNOU(parentUL)) {
                var currentParent = closest(parentUL, '.' + LISTITEM);
                this.ensureParentCheckState(currentParent);
            }
        }
    };
    TreeView.prototype.ensureChildCheckState = function (element, e) {
        if (!isNOU(element)) {
            var childElement = select('.' + PARENTITEM, element);
            var checkBoxes = void 0;
            if (!isNOU(childElement)) {
                checkBoxes = selectAll('.' + CHECKBOXWRAP, childElement);
                var isChecked = element.getElementsByClassName(CHECKBOXFRAME)[0].classList.contains(CHECK);
                var checkedState = void 0;
                for (var index = 0; index < checkBoxes.length; index++) {
                    if (!isNOU(this.currentLoadData) && !isNOU(getValue(this.fields.isChecked, this.currentLoadData[index]))) {
                        checkedState = getValue(this.fields.isChecked, this.currentLoadData[index]) ? 'check' : 'uncheck';
                        if (this.ele !== -1) {
                            checkedState = isChecked ? 'check' : 'uncheck';
                        }
                    }
                    else {
                        var isNodeChecked = checkBoxes[index].getElementsByClassName(CHECKBOXFRAME)[0].classList.contains(CHECK);
                        checkedState = (!this.isLoaded && isNodeChecked) ? 'check' : (isChecked ? 'check' : 'uncheck');
                    }
                    this.changeState(checkBoxes[index], checkedState, e, true, true);
                }
            }
        }
    };
    TreeView.prototype.doCheckBoxAction = function (nodes, doCheck) {
        if (!isNOU(nodes)) {
            for (var i = 0, len = nodes.length; i < len; i++) {
                var liEle = this.getElement(nodes[i]);
                if (isNOU(liEle)) {
                    continue;
                }
                var checkBox = select('.' + PARENTITEM + ' .' + CHECKBOXWRAP, liEle);
                this.validateCheckNode(checkBox, !doCheck, liEle, null);
            }
        }
        else {
            var checkBoxes = selectAll('.' + CHECKBOXWRAP, this.element);
            for (var index = 0; index < checkBoxes.length; index++) {
                this.changeState(checkBoxes[index], doCheck ? 'check' : 'uncheck');
            }
        }
    };
    TreeView.prototype.changeState = function (wrapper, state, e, isPrevent, isAdd) {
        var ariaState;
        var eventArgs;
        var currLi = closest(wrapper, '.' + LISTITEM);
        if (!isPrevent) {
            this.checkActionNodes = [];
            eventArgs = this.getCheckEvent(currLi, state, e);
            this.trigger('nodeChecking', eventArgs);
            if (eventArgs.cancel) {
                return;
            }
        }
        var frameSpan = wrapper.getElementsByClassName(CHECKBOXFRAME)[0];
        if (state === 'check' && !frameSpan.classList.contains(CHECK)) {
            frameSpan.classList.remove(INDETERMINATE);
            frameSpan.classList.add(CHECK);
            this.addCheck(currLi);
            ariaState = 'true';
        }
        else if (state === 'uncheck' && (frameSpan.classList.contains(CHECK) || frameSpan.classList.contains(INDETERMINATE))) {
            removeClass([frameSpan], [CHECK, INDETERMINATE]);
            this.removeCheck(currLi);
            ariaState = 'false';
        }
        else if (state === 'indeterminate' && !frameSpan.classList.contains(INDETERMINATE) && this.autoCheck) {
            frameSpan.classList.remove(CHECK);
            frameSpan.classList.add(INDETERMINATE);
            this.removeCheck(currLi);
            ariaState = 'mixed';
        }
        ariaState = state === 'check' ? 'true' : state === 'uncheck' ? 'false' : ariaState;
        if (!isNOU(ariaState)) {
            wrapper.setAttribute('aria-checked', ariaState);
        }
        if (isAdd) {
            var data = [].concat([], this.checkActionNodes);
            eventArgs = this.getCheckEvent(currLi, state, e);
            if (isUndefined(isPrevent)) {
                eventArgs.data = data;
            }
        }
        if (!isPrevent) {
            if (!isNOU(ariaState)) {
                wrapper.setAttribute('aria-checked', ariaState);
                eventArgs.data[0].checked = ariaState;
                this.trigger('nodeChecked', eventArgs);
                this.checkActionNodes = [];
            }
        }
    };
    TreeView.prototype.addCheck = function (liEle) {
        var id = liEle.getAttribute('data-uid');
        if (!isNOU(id) && this.checkedNodes.indexOf(id) === -1) {
            this.checkedNodes.push(id);
        }
    };
    TreeView.prototype.removeCheck = function (liEle) {
        var index = this.checkedNodes.indexOf(liEle.getAttribute('data-uid'));
        if (index > -1) {
            this.checkedNodes.splice(index, 1);
        }
    };
    TreeView.prototype.getCheckEvent = function (currLi, action, e) {
        this.checkActionNodes.push(this.getNodeData(currLi));
        var nodeData = this.checkActionNodes;
        return { action: action, cancel: false, isInteracted: isNOU(e) ? false : true, node: currLi, data: nodeData };
    };
    TreeView.prototype.finalize = function () {
        var firstUl = select('.' + PARENTITEM, this.element);
        firstUl.setAttribute('role', treeAriaAttr.treeRole);
        this.setMultiSelect(this.allowMultiSelection);
        var firstNode = select('.' + LISTITEM, this.element);
        if (firstNode) {
            addClass([firstNode], FOCUS);
            this.updateIdAttr(null, firstNode);
        }
        this.hasPid = this.rootData[0] ? this.rootData[0].hasOwnProperty(this.fields.parentID) : false;
        this.doExpandAction();
    };
    TreeView.prototype.doExpandAction = function () {
        var eUids = this.expandedNodes;
        if (this.isInitalExpand && eUids.length > 0) {
            this.setProperties({ expandedNodes: [] }, true);
            if (this.fields.dataSource instanceof DataManager) {
                this.expandGivenNodes(eUids);
            }
            else {
                for (var i = 0; i < eUids.length; i++) {
                    var eNode = select('[data-uid="' + eUids[i] + '"]', this.element);
                    if (!isNOU(eNode)) {
                        var icon = select('.' + EXPANDABLE, select('.' + TEXTWRAP, eNode));
                        if (!isNOU(icon)) {
                            this.expandAction(eNode, icon, null);
                        }
                    }
                }
                this.afterFinalized();
            }
        }
        else {
            this.afterFinalized();
        }
    };
    TreeView.prototype.expandGivenNodes = function (arr) {
        var proxy = this;
        this.expandCallback(arr[this.index], function () {
            proxy.index++;
            if (proxy.index < arr.length) {
                proxy.expandGivenNodes(arr);
            }
            else {
                proxy.afterFinalized();
            }
        });
    };
    TreeView.prototype.expandCallback = function (eUid, callback) {
        var eNode = select('[data-uid="' + eUid + '"]', this.element);
        if (!isNOU(eNode)) {
            var icon = select('.' + EXPANDABLE, select('.' + TEXTWRAP, eNode));
            if (!isNOU(icon)) {
                this.expandAction(eNode, icon, null, false, callback);
            }
            else {
                callback();
            }
        }
        else {
            callback();
        }
    };
    TreeView.prototype.afterFinalized = function () {
        this.doSelectionAction();
        this.updateCheckedProp();
        this.isLoaded = true;
        this.isAnimate = true;
        this.isInitalExpand = false;
        var eventArgs = { data: this.treeData };
        this.trigger('dataBound', eventArgs);
    };
    TreeView.prototype.doSelectionAction = function () {
        var sNodes = selectAll('.' + SELECTED, this.element);
        var sUids = this.selectedNodes;
        if (sUids.length > 0) {
            this.setProperties({ selectedNodes: [] }, true);
            for (var i = 0; i < sUids.length; i++) {
                var sNode = select('[data-uid="' + sUids[i] + '"]', this.element);
                this.selectNode(sNode, null, true);
                if (!this.allowMultiSelection) {
                    break;
                }
            }
        }
        else {
            this.selectGivenNodes(sNodes);
        }
        removeClass(sNodes, SELECTED);
    };
    TreeView.prototype.selectGivenNodes = function (sNodes) {
        for (var i = 0; i < sNodes.length; i++) {
            if (!sNodes[i].classList.contains('e-disable')) {
                this.selectNode(sNodes[i], null, true);
            }
            if (!this.allowMultiSelection) {
                break;
            }
        }
    };
    TreeView.prototype.clickHandler = function (event) {
        var target = event.originalEvent.target;
        EventHandler.remove(this.element, 'contextmenu', this.preventContextMenu);
        if (!target || this.dragStartAction) {
            return;
        }
        else {
            var classList = target.classList;
            var li = closest(target, '.' + LISTITEM);
            if (!li) {
                return;
            }
            else {
                this.removeHover();
                this.setFocusElement(li);
                if (this.showCheckBox && !li.classList.contains('e-disable')) {
                    var checkWrapper = closest(target, '.' + CHECKBOXWRAP);
                    if (!isNOU(checkWrapper)) {
                        var checkElement = select('.' + CHECKBOXFRAME, checkWrapper);
                        this.validateCheckNode(checkWrapper, checkElement.classList.contains(CHECK), li, event.originalEvent);
                        this.triggerClickEvent(event.originalEvent, li);
                        return;
                    }
                }
                if (classList.contains(EXPANDABLE)) {
                    this.expandAction(li, target, event);
                }
                else if (classList.contains(COLLAPSIBLE)) {
                    this.collapseNode(li, target, event);
                }
                else {
                    if (!classList.contains(PARENTITEM) && !classList.contains(LISTITEM)) {
                        this.toggleSelect(li, event.originalEvent, false);
                    }
                }
                this.triggerClickEvent(event.originalEvent, li);
            }
        }
    };
    TreeView.prototype.nodeCheckingEvent = function (wrapper, isCheck, e) {
        var currLi = closest(wrapper, '.' + LISTITEM);
        this.checkActionNodes = [];
        var ariaState = !isCheck ? 'true' : 'false';
        if (!isNOU(ariaState)) {
            wrapper.setAttribute('aria-checked', ariaState);
        }
        var eventArgs = this.getCheckEvent(currLi, isCheck ? 'uncheck' : 'check', e);
        this.trigger('nodeChecking', eventArgs);
        return eventArgs;
    };
    TreeView.prototype.nodeCheckedEvent = function (wrapper, isCheck, e) {
        var currLi = closest(wrapper, '.' + LISTITEM);
        var eventArgs = this.getCheckEvent(wrapper, isCheck ? 'uncheck' : 'check', e);
        eventArgs.data = eventArgs.data.splice(0, eventArgs.data.length - 1);
        this.trigger('nodeChecked', eventArgs);
    };
    TreeView.prototype.triggerClickEvent = function (e, li) {
        var eventArgs = {
            event: e,
            node: li,
        };
        this.trigger('nodeClicked', eventArgs);
    };
    TreeView.prototype.expandNode = function (currLi, icon, loaded) {
        var _this = this;
        if (icon.classList.contains(LOAD)) {
            this.hideSpinner(icon);
        }
        if (!this.initialRender) {
            icon.classList.add('interaction');
        }
        if (loaded !== true || (loaded === true && currLi.classList.contains('e-expanded'))) {
            if (this.preventExpand !== true) {
                removeClass([icon], EXPANDABLE);
                addClass([icon], COLLAPSIBLE);
                var start_1 = 0;
                var end_1 = 0;
                var proxy_1 = this;
                var ul_1 = select('.' + PARENTITEM, currLi);
                var liEle_1 = currLi;
                this.setHeight(liEle_1, ul_1);
                if (this.isAnimate) {
                    this.aniObj.animate(ul_1, {
                        name: this.animation.expand.effect,
                        duration: this.animation.expand.duration,
                        timingFunction: this.animation.expand.easing,
                        begin: function (args) {
                            liEle_1.style.overflow = 'hidden';
                            start_1 = liEle_1.offsetHeight;
                            end_1 = select('.' + TEXTWRAP, currLi).offsetHeight;
                        },
                        progress: function (args) {
                            args.element.style.display = 'block';
                            proxy_1.animateHeight(args, start_1, end_1);
                        },
                        end: function (args) {
                            args.element.style.display = 'block';
                            _this.expandedNode(liEle_1, ul_1, icon);
                        }
                    });
                }
                else {
                    this.expandedNode(liEle_1, ul_1, icon);
                }
            }
        }
        else {
            var ul = select('.' + PARENTITEM, currLi);
            ul.style.display = 'none';
            if (this.fields.dataSource instanceof DataManager === true) {
                this.preventExpand = false;
            }
        }
        if (this.initialRender) {
            icon.classList.add('interaction');
        }
    };
    TreeView.prototype.expandedNode = function (currLi, ul, icon) {
        ul.style.display = 'block';
        currLi.style.display = 'block';
        currLi.style.overflow = '';
        currLi.style.height = '';
        removeClass([icon], PROCESS);
        this.addExpand(currLi);
        if (this.isLoaded && this.expandArgs) {
            this.expandArgs = this.getExpandEvent(currLi, null);
            this.trigger('nodeExpanded', this.expandArgs);
        }
    };
    TreeView.prototype.addExpand = function (liEle) {
        liEle.setAttribute('aria-expanded', 'true');
        removeClass([liEle], NODECOLLAPSED);
        var id = liEle.getAttribute('data-uid');
        if (!isNOU(id) && this.expandedNodes.indexOf(id) === -1) {
            this.expandedNodes.push(id);
        }
    };
    TreeView.prototype.collapseNode = function (currLi, icon, e) {
        var _this = this;
        if (icon.classList.contains(PROCESS)) {
            return;
        }
        else {
            addClass([icon], PROCESS);
        }
        var colArgs;
        if (this.isLoaded) {
            colArgs = this.getExpandEvent(currLi, e);
            this.trigger('nodeCollapsing', colArgs);
            if (colArgs.cancel) {
                removeClass([icon], PROCESS);
                return;
            }
        }
        removeClass([icon], COLLAPSIBLE);
        addClass([icon], EXPANDABLE);
        var start = 0;
        var end = 0;
        var proxy = this;
        var ul = select('.' + PARENTITEM, currLi);
        var liEle = currLi;
        if (this.isAnimate) {
            this.aniObj.animate(ul, {
                name: this.animation.collapse.effect,
                duration: this.animation.collapse.duration,
                timingFunction: this.animation.collapse.easing,
                begin: function (args) {
                    liEle.style.overflow = 'hidden';
                    start = select('.' + TEXTWRAP, currLi).offsetHeight;
                    end = liEle.offsetHeight;
                },
                progress: function (args) {
                    proxy.animateHeight(args, start, end);
                },
                end: function (args) {
                    args.element.style.display = 'none';
                    _this.collapsedNode(liEle, ul, icon, colArgs);
                }
            });
        }
        else {
            this.collapsedNode(liEle, ul, icon, colArgs);
        }
    };
    TreeView.prototype.collapsedNode = function (liEle, ul, icon, colArgs) {
        ul.style.display = 'none';
        liEle.style.overflow = '';
        liEle.style.height = '';
        removeClass([icon], PROCESS);
        this.removeExpand(liEle);
        if (this.isLoaded) {
            this.trigger('nodeCollapsed', colArgs);
        }
    };
    TreeView.prototype.removeExpand = function (liEle, toRemove) {
        if (toRemove) {
            liEle.removeAttribute('aria-expanded');
        }
        else {
            this.disableExpandAttr(liEle);
        }
        var index = this.expandedNodes.indexOf(liEle.getAttribute('data-uid'));
        if (index > -1) {
            this.expandedNodes.splice(index, 1);
        }
    };
    TreeView.prototype.disableExpandAttr = function (liEle) {
        liEle.setAttribute('aria-expanded', 'false');
        addClass([liEle], NODECOLLAPSED);
    };
    TreeView.prototype.setHeight = function (currLi, ul) {
        ul.style.display = 'block';
        ul.style.visibility = 'hidden';
        currLi.style.height = currLi.offsetHeight + 'px';
        ul.style.display = 'none';
        ul.style.visibility = '';
    };
    TreeView.prototype.animateHeight = function (args, start, end) {
        var remaining = (args.duration - args.timeStamp) / args.duration;
        var currentHeight = (end - start) * remaining + start;
        args.element.parentElement.style.height = currentHeight + 'px';
    };
    TreeView.prototype.renderChildNodes = function (parentLi, expandChild, callback, loaded) {
        var _this = this;
        var eicon = select('div.' + ICON, parentLi);
        if (isNOU(eicon)) {
            return;
        }
        this.showSpinner(eicon);
        var childItems;
        if (this.fields.dataSource instanceof DataManager) {
            var level = this.parents(parentLi, '.' + PARENTITEM).length;
            var mapper_1 = this.getChildFields(this.fields, level, 1);
            if (isNOU(mapper_1) || isNOU(mapper_1.dataSource)) {
                detach(eicon);
                this.removeExpand(parentLi, true);
                return;
            }
            this.treeList.push('false');
            if (this.fields.dataSource instanceof DataManager && (this.fields.dataSource.dataSource.offline)) {
                this.treeList.pop();
                childItems = this.getChildNodes(this.treeData, parentLi.getAttribute('data-uid'));
                this.loadChild(childItems, mapper_1, eicon, parentLi, expandChild, callback, loaded);
            }
            else {
                mapper_1.dataSource.executeQuery(this.getQuery(mapper_1, parentLi.getAttribute('data-uid'))).then(function (e) {
                    _this.treeList.pop();
                    childItems = e.result;
                    _this.loadChild(childItems, mapper_1, eicon, parentLi, expandChild, callback, loaded);
                });
            }
        }
        else {
            childItems = this.getChildNodes(this.treeData, parentLi.getAttribute('data-uid'));
            this.currentLoadData = childItems;
            if (isNOU(childItems) || childItems.length === 0) {
                detach(eicon);
                this.removeExpand(parentLi, true);
                return;
            }
            else {
                this.listBaseOption.ariaAttributes.level = parseFloat(parentLi.getAttribute('aria-level')) + 1;
                parentLi.appendChild(ListBase.createList(this.createElement, this.getSortedData(childItems), this.listBaseOption));
                this.expandNode(parentLi, eicon, loaded);
                this.ensureCheckNode(parentLi);
                this.finalizeNode(parentLi);
                this.disableTreeNodes(childItems);
                this.renderSubChild(parentLi, expandChild, loaded);
            }
        }
    };
    TreeView.prototype.loadChild = function (childItems, mapper, eicon, parentLi, expandChild, callback, loaded) {
        this.currentLoadData = childItems;
        if (isNOU(childItems) || childItems.length === 0) {
            detach(eicon);
            this.removeExpand(parentLi, true);
        }
        else {
            this.updateListProp(mapper);
            if (this.fields.dataSource instanceof DataManager && !this.fields.dataSource.dataSource.offline) {
                var id = parentLi.getAttribute('data-uid');
                var nodeData = this.getNodeObject(id);
                setValue('child', childItems, nodeData);
            }
            this.listBaseOption.ariaAttributes.level = parseFloat(parentLi.getAttribute('aria-level')) + 1;
            parentLi.appendChild(ListBase.createList(this.createElement, childItems, this.listBaseOption));
            this.expandNode(parentLi, eicon, loaded);
            this.ensureCheckNode(parentLi);
            this.finalizeNode(parentLi);
            this.disableTreeNodes(childItems);
            this.renderSubChild(parentLi, expandChild, loaded);
        }
        if (callback) {
            callback();
        }
        if (this.treeList.length === 0 && !this.isLoaded) {
            this.finalize();
        }
    };
    TreeView.prototype.disableTreeNodes = function (childItems) {
        var i = 0;
        while (i < childItems.length) {
            var id = childItems[i][this.fields.id].toString();
            if (this.disableNode !== undefined && this.disableNode.indexOf(id) !== -1) {
                this.doDisableAction([id]);
            }
            i++;
        }
    };
    TreeView.prototype.ensureCheckNode = function (element) {
        if (this.showCheckBox) {
            this.ele = (this.checkedElement) ? this.checkedElement.indexOf(element.getAttribute('data-uid')) : null;
            if (this.autoCheck) {
                this.ensureChildCheckState(element);
                this.ensureParentCheckState(element);
            }
        }
        this.currentLoadData = null;
    };
    TreeView.prototype.getFields = function (mapper, nodeLevel, dataLevel) {
        if (nodeLevel === dataLevel) {
            return mapper;
        }
        else {
            return this.getFields(this.getChildMapper(mapper), nodeLevel, dataLevel + 1);
        }
    };
    TreeView.prototype.getChildFields = function (mapper, nodeLevel, dataLevel) {
        var childData;
        if (nodeLevel === dataLevel) {
            return this.getChildMapper(mapper);
        }
        else {
            return this.getChildFields(this.getChildMapper(mapper), nodeLevel, dataLevel + 1);
        }
    };
    TreeView.prototype.getChildMapper = function (mapper) {
        return (typeof mapper.child === 'string' || isNOU(mapper.child)) ? mapper : mapper.child;
    };
    TreeView.prototype.getChildNodes = function (obj, parentId, isRoot) {
        if (isRoot === void 0) { isRoot = false; }
        var childNodes;
        if (isNOU(obj)) {
            return childNodes;
        }
        else if (this.dataType === 1) {
            return this.getChildGroup(this.groupedData, parentId, isRoot);
        }
        else {
            if (typeof this.fields.child === 'string') {
                for (var i = 0, objlen = obj.length; i < objlen; i++) {
                    var dataId = getValue(this.fields.id, obj[i]);
                    if (dataId && dataId.toString() === parentId) {
                        return getValue(this.fields.child, obj[i]);
                    }
                    else if (!isNOU(getValue(this.fields.child, obj[i]))) {
                        childNodes = this.getChildNodes(getValue(this.fields.child, obj[i]), parentId);
                        if (childNodes !== undefined) {
                            break;
                        }
                    }
                }
            }
        }
        return childNodes;
    };
    TreeView.prototype.getChildGroup = function (data, parentId, isRoot) {
        var childNodes;
        if (isNOU(data)) {
            return childNodes;
        }
        for (var i = 0, objlen = data.length; i < objlen; i++) {
            if (!isNOU(data[i][0]) && !isNOU(getValue(this.fields.parentID, data[i][0]))) {
                if (getValue(this.fields.parentID, data[i][0]).toString() === parentId) {
                    return data[i];
                }
            }
            else if (isRoot) {
                return data[i];
            }
            else {
                return [];
            }
        }
        return childNodes;
    };
    TreeView.prototype.renderSubChild = function (element, expandChild, loaded) {
        if (expandChild) {
            var cIcons = selectAll('.' + EXPANDABLE, element);
            for (var i = 0, len = cIcons.length; i < len; i++) {
                var icon = cIcons[i];
                if (element.querySelector('.e-icons') !== cIcons[i]) {
                    var curLi = closest(icon, '.' + LISTITEM);
                    this.expandArgs = this.getExpandEvent(curLi, null);
                    if (loaded !== true) {
                        this.trigger('nodeExpanding', this.expandArgs);
                    }
                    this.renderChildNodes(curLi, expandChild, null, loaded);
                }
            }
        }
    };
    TreeView.prototype.toggleSelect = function (li, e, multiSelect) {
        if (!li.classList.contains('e-disable')) {
            if (this.allowMultiSelection && ((e && e.ctrlKey) || multiSelect) && this.isActive(li)) {
                this.unselectNode(li, e);
            }
            else {
                this.selectNode(li, e, multiSelect);
            }
        }
    };
    TreeView.prototype.isActive = function (li) {
        return li.classList.contains(ACTIVE) ? true : false;
    };
    TreeView.prototype.selectNode = function (li, e, multiSelect) {
        if (isNOU(li) || (!this.allowMultiSelection && this.isActive(li) && !isNOU(e))) {
            this.setFocusElement(li);
            return;
        }
        var eventArgs;
        if (this.isLoaded) {
            eventArgs = this.getSelectEvent(li, 'select', e);
            this.trigger('nodeSelecting', eventArgs);
            if (eventArgs.cancel) {
                return;
            }
        }
        if (!this.allowMultiSelection || (!multiSelect && (!e || (e && !e.ctrlKey)))) {
            this.removeSelectAll();
        }
        if (this.allowMultiSelection && e && e.shiftKey) {
            if (!this.startNode) {
                this.startNode = li;
            }
            var startIndex = this.liList.indexOf(this.startNode);
            var endIndex = this.liList.indexOf(li);
            if (startIndex > endIndex) {
                var temp = startIndex;
                startIndex = endIndex;
                endIndex = temp;
            }
            for (var i = startIndex; i <= endIndex; i++) {
                var currNode = this.liList[i];
                if (isVisible(currNode) && !currNode.classList.contains('e-disable')) {
                    this.addSelect(currNode);
                }
            }
        }
        else {
            this.startNode = li;
            this.addSelect(li);
        }
        this.setFocusElement(li);
        if (this.isLoaded) {
            eventArgs.nodeData = this.getNodeData(li);
            this.trigger('nodeSelected', eventArgs);
        }
    };
    TreeView.prototype.unselectNode = function (li, e) {
        var eventArgs;
        if (this.isLoaded) {
            eventArgs = this.getSelectEvent(li, 'un-select', e);
            this.trigger('nodeSelecting', eventArgs);
            if (eventArgs.cancel) {
                return;
            }
        }
        this.removeSelect(li);
        this.setFocusElement(li);
        if (this.isLoaded) {
            eventArgs.nodeData = this.getNodeData(li);
            this.trigger('nodeSelected', eventArgs);
        }
    };
    TreeView.prototype.setFocusElement = function (li) {
        if (!isNOU(li)) {
            var focusedNode = this.getFocusedNode();
            if (focusedNode) {
                removeClass([focusedNode], FOCUS);
            }
            addClass([li], FOCUS);
            this.updateIdAttr(focusedNode, li);
        }
    };
    TreeView.prototype.addSelect = function (liEle) {
        liEle.setAttribute('aria-selected', 'true');
        addClass([liEle], ACTIVE);
        var id = liEle.getAttribute('data-uid');
        if (!isNOU(id) && this.selectedNodes.indexOf(id) === -1) {
            this.selectedNodes.push(id);
        }
    };
    TreeView.prototype.removeSelect = function (liEle) {
        if (this.allowMultiSelection) {
            liEle.setAttribute('aria-selected', 'false');
        }
        else {
            liEle.removeAttribute('aria-selected');
        }
        removeClass([liEle], ACTIVE);
        var index = this.selectedNodes.indexOf(liEle.getAttribute('data-uid'));
        if (index > -1) {
            this.selectedNodes.splice(index, 1);
        }
    };
    TreeView.prototype.removeSelectAll = function () {
        var selectedLI = this.element.querySelectorAll('.' + ACTIVE);
        for (var _i = 0, selectedLI_1 = selectedLI; _i < selectedLI_1.length; _i++) {
            var ele = selectedLI_1[_i];
            if (this.allowMultiSelection) {
                ele.setAttribute('aria-selected', 'false');
            }
            else {
                ele.removeAttribute('aria-selected');
            }
        }
        removeClass(selectedLI, ACTIVE);
        this.setProperties({ selectedNodes: [] }, true);
    };
    TreeView.prototype.getSelectEvent = function (currLi, action, e) {
        var nodeData = this.getNodeData(currLi);
        return { action: action, cancel: false, isInteracted: isNOU(e) ? false : true, node: currLi, nodeData: nodeData };
    };
    TreeView.prototype.setExpandOnType = function () {
        this.expandOnType = (this.expandOn === 'Auto') ? (Browser.isDevice ? 'Click' : 'DblClick') : this.expandOn;
    };
    TreeView.prototype.expandHandler = function (e) {
        var target = e.originalEvent.target;
        if (!target || target.classList.contains(INPUT) || target.classList.contains(ROOT) ||
            target.classList.contains(PARENTITEM) || target.classList.contains(LISTITEM) ||
            target.classList.contains(ICON) || this.showCheckBox && closest(target, '.' + CHECKBOXWRAP)) {
            return;
        }
        else {
            this.expandCollapseAction(closest(target, '.' + LISTITEM), e);
        }
    };
    TreeView.prototype.expandCollapseAction = function (currLi, e) {
        var icon = select('div.' + ICON, currLi);
        if (!icon || icon.classList.contains(PROCESS)) {
            return;
        }
        else {
            var classList = icon.classList;
            if (classList.contains(EXPANDABLE)) {
                this.expandAction(currLi, icon, e);
            }
            else {
                this.collapseNode(currLi, icon, e);
            }
        }
    };
    TreeView.prototype.expandAction = function (currLi, icon, e, expandChild, callback) {
        if (icon.classList.contains(PROCESS)) {
            return;
        }
        else {
            addClass([icon], PROCESS);
        }
        if (this.isLoaded) {
            this.expandArgs = this.getExpandEvent(currLi, e);
            this.trigger('nodeExpanding', this.expandArgs);
            if (this.expandArgs.cancel) {
                removeClass([icon], PROCESS);
                return;
            }
        }
        var ul = select('.' + PARENTITEM, currLi);
        if (ul && ul.nodeName === 'UL') {
            this.expandNode(currLi, icon);
        }
        else {
            this.renderChildNodes(currLi, expandChild, callback);
        }
    };
    TreeView.prototype.keyActionHandler = function (e) {
        var target = e.target;
        var focusedNode = this.getFocusedNode();
        if (target && target.classList.contains(INPUT)) {
            var inpEle = target;
            if (e.action === 'enter') {
                inpEle.blur();
                this.element.focus();
                addClass([focusedNode], HOVER);
            }
            else if (e.action === 'escape') {
                inpEle.value = this.oldText;
                inpEle.blur();
                this.element.focus();
                addClass([focusedNode], HOVER);
            }
            return;
        }
        e.preventDefault();
        var eventArgs = {
            cancel: false,
            event: e,
            node: focusedNode,
        };
        this.trigger('keyPress', eventArgs);
        if (eventArgs.cancel) {
            return;
        }
        switch (e.action) {
            case 'space':
                if (this.showCheckBox) {
                    this.checkNode(e);
                }
                break;
            case 'moveRight':
                this.openNode(this.enableRtl ? false : true, e);
                break;
            case 'moveLeft':
                this.openNode(this.enableRtl ? true : false, e);
                break;
            case 'shiftDown':
                this.shiftKeySelect(true, e);
                break;
            case 'moveDown':
            case 'ctrlDown':
            case 'csDown':
                this.navigateNode(true);
                break;
            case 'shiftUp':
                this.shiftKeySelect(false, e);
                break;
            case 'moveUp':
            case 'ctrlUp':
            case 'csUp':
                this.navigateNode(false);
                break;
            case 'home':
            case 'shiftHome':
            case 'ctrlHome':
            case 'csHome':
                this.navigateRootNode(true);
                break;
            case 'end':
            case 'shiftEnd':
            case 'ctrlEnd':
            case 'csEnd':
                this.navigateRootNode(false);
                break;
            case 'enter':
            case 'ctrlEnter':
            case 'shiftEnter':
            case 'csEnter':
                this.toggleSelect(focusedNode, e);
                break;
            case 'f2':
                if (this.allowEditing && !focusedNode.classList.contains('e-disable')) {
                    this.createTextbox(focusedNode, e);
                }
                break;
            case 'ctrlA':
                if (this.allowMultiSelection) {
                    var sNodes = selectAll('.' + LISTITEM + ':not(.' + ACTIVE + ')', this.element);
                    this.selectGivenNodes(sNodes);
                }
                break;
        }
    };
    TreeView.prototype.navigateToFocus = function (isUp) {
        var focusNode = this.getFocusedNode().querySelector('.' + TEXTWRAP);
        var pos = focusNode.getBoundingClientRect();
        var parent = this.getScrollParent(this.element);
        if (!isNOU(parent)) {
            var parentPos = parent.getBoundingClientRect();
            if (pos.bottom > parentPos.bottom) {
                parent.scrollTop += pos.bottom - parentPos.bottom;
            }
            else if (pos.top < parentPos.top) {
                parent.scrollTop -= parentPos.top - pos.top;
            }
        }
        var isVisible = this.isVisibleInViewport(focusNode);
        if (!isVisible) {
            focusNode.scrollIntoView(isUp);
        }
    };
    TreeView.prototype.isVisibleInViewport = function (txtWrap) {
        var pos = txtWrap.getBoundingClientRect();
        return (pos.top >= 0 && pos.left >= 0 && pos.bottom <= (window.innerHeight || document.documentElement.clientHeight) &&
            pos.right <= (window.innerWidth || document.documentElement.clientWidth));
    };
    TreeView.prototype.getScrollParent = function (node) {
        if (isNOU(node)) {
            return null;
        }
        return (node.scrollHeight > node.clientHeight) ? node : this.getScrollParent(node.parentElement);
    };
    TreeView.prototype.shiftKeySelect = function (isTowards, e) {
        if (this.allowMultiSelection) {
            var focusedNode = this.getFocusedNode();
            var nextNode = isTowards ? this.getNextNode(focusedNode) : this.getPrevNode(focusedNode);
            this.removeHover();
            this.setFocusElement(nextNode);
            this.toggleSelect(nextNode, e, false);
            this.navigateToFocus(!isTowards);
        }
        else {
            this.navigateNode(isTowards);
        }
    };
    TreeView.prototype.checkNode = function (e) {
        var focusedNode = this.getFocusedNode();
        var checkWrap = select('.' + CHECKBOXWRAP, focusedNode);
        var isChecked = select(' .' + CHECKBOXFRAME, checkWrap).classList.contains(CHECK);
        if (!focusedNode.classList.contains('e-disable')) {
            this.validateCheckNode(checkWrap, isChecked, focusedNode, e);
        }
    };
    TreeView.prototype.validateCheckNode = function (checkWrap, isCheck, li, e) {
        var eventArgs = this.nodeCheckingEvent(checkWrap, isCheck, e);
        if (eventArgs.cancel) {
            return;
        }
        if (this.checkedElement.indexOf(li.getAttribute('data-uid')) === -1) {
            this.checkedElement.push(li.getAttribute('data-uid'));
            var child = this.getChildNodes(this.treeData, li.getAttribute('data-uid'));
            (child !== null) ? this.allCheckNode(child, this.checkedElement, null, null, false) : child = null;
        }
        this.changeState(checkWrap, isCheck ? 'uncheck' : 'check', e, true);
        if (this.autoCheck) {
            this.ensureChildCheckState(li);
            this.ensureParentCheckState(closest(closest(li, '.' + PARENTITEM), '.' + LISTITEM));
        }
        this.nodeCheckedEvent(checkWrap, isCheck, e);
    };
    //This method can be used to get all child nodes of a parent by passing the children of a parent along with 'validateCheck' set to false
    TreeView.prototype.allCheckNode = function (child, newCheck, checked, childCheck, validateCheck) {
        if (child) {
            for (var length_1 = 0; length_1 < child.length; length_1++) {
                var childId = getValue(this.fields.id, child[length_1]);
                var check = this.element.querySelector('[data-uid="' + childId + '"]');
                //Validates isChecked case while no UI interaction has been performed on the node or it's parent
                if (validateCheck !== false && this.checkedElement.indexOf(childId.toString()) === -1) {
                    if (((check === null && !isNOU(child[length_1][this.fields.isChecked]) && newCheck.indexOf(childId.toString()) === -1)
                        || childCheck === 0 || checked === 2)) {
                        (child[length_1][this.fields.isChecked] !== false || checked === 2) ? newCheck.push(childId.toString())
                            : childCheck = null;
                        childCheck = (child[length_1][this.fields.isChecked] !== false || checked === 2) ? 0 : null;
                    }
                }
                //Pushes child checked node done thro' UI interaction
                if (newCheck.indexOf(childId.toString()) === -1 && isNOU(checked)) {
                    newCheck.push(childId.toString());
                }
                //Gets if any next level children are available for child nodes
                if (getValue(this.fields.hasChildren, child[length_1]) === true ||
                    getValue(this.fields.child.toString(), child[length_1])) {
                    var id = getValue(this.fields.id, child[length_1]);
                    var childId_1 = this.getChildNodes(this.treeData, id.toString());
                    if (childId_1) {
                        (isNOU(validateCheck)) ? this.allCheckNode(childId_1, newCheck, checked, childCheck) :
                            this.allCheckNode(childId_1, newCheck, checked, childCheck, validateCheck);
                        childCheck = null;
                    }
                }
                childCheck = null;
            }
        }
    };
    TreeView.prototype.openNode = function (toBeOpened, e) {
        var focusedNode = this.getFocusedNode();
        var icon = select('div.' + ICON, focusedNode);
        if (toBeOpened) {
            if (!icon) {
                return;
            }
            else if (icon.classList.contains(EXPANDABLE)) {
                this.expandAction(focusedNode, icon, e);
            }
            else {
                this.focusNextNode(focusedNode, true);
            }
        }
        else {
            if (icon && icon.classList.contains(COLLAPSIBLE)) {
                this.collapseNode(focusedNode, icon, e);
            }
            else {
                var parentLi = closest(closest(focusedNode, '.' + PARENTITEM), '.' + LISTITEM);
                if (!parentLi) {
                    return;
                }
                else {
                    if (!parentLi.classList.contains('e-disable')) {
                        this.setFocus(focusedNode, parentLi);
                        this.navigateToFocus(true);
                    }
                }
            }
        }
    };
    TreeView.prototype.navigateNode = function (isTowards) {
        var focusedNode = this.getFocusedNode();
        this.focusNextNode(focusedNode, isTowards);
    };
    TreeView.prototype.navigateRootNode = function (isBackwards) {
        var focusedNode = this.getFocusedNode();
        var rootNode = isBackwards ? this.getRootNode() : this.getEndNode();
        if (!rootNode.classList.contains('e-disable')) {
            this.setFocus(focusedNode, rootNode);
            this.navigateToFocus(isBackwards);
        }
    };
    TreeView.prototype.getFocusedNode = function () {
        var selectedItem;
        var fNode = select('.' + LISTITEM + '.' + FOCUS, this.element);
        if (isNOU(fNode)) {
            selectedItem = select('.' + LISTITEM, this.element);
        }
        return isNOU(fNode) ? (isNOU(selectedItem) ? this.element.firstElementChild : selectedItem) : fNode;
    };
    TreeView.prototype.focusNextNode = function (li, isTowards) {
        var nextNode = isTowards ? this.getNextNode(li) : this.getPrevNode(li);
        this.setFocus(li, nextNode);
        this.navigateToFocus(!isTowards);
        if (nextNode.classList.contains('e-disable')) {
            var lastChild = nextNode.lastChild;
            if (nextNode.previousSibling == null && nextNode.classList.contains('e-level-1')) {
                this.focusNextNode(nextNode, true);
            }
            else if (nextNode.nextSibling == null && nextNode.classList.contains('e-node-collapsed')) {
                this.focusNextNode(nextNode, false);
            }
            else if (nextNode.nextSibling == null && lastChild.classList.contains('e-text-content')) {
                this.focusNextNode(nextNode, false);
            }
            else {
                this.focusNextNode(nextNode, isTowards);
            }
        }
    };
    TreeView.prototype.getNextNode = function (li) {
        var index = this.liList.indexOf(li);
        var nextNode;
        do {
            index++;
            nextNode = this.liList[index];
            if (isNOU(nextNode)) {
                return li;
            }
        } while (!isVisible(nextNode));
        return nextNode;
    };
    TreeView.prototype.getPrevNode = function (li) {
        var index = this.liList.indexOf(li);
        var prevNode;
        do {
            index--;
            prevNode = this.liList[index];
            if (isNOU(prevNode)) {
                return li;
            }
        } while (!isVisible(prevNode));
        return prevNode;
    };
    TreeView.prototype.getRootNode = function () {
        var index = 0;
        var rootNode;
        do {
            rootNode = this.liList[index];
            index++;
        } while (!isVisible(rootNode));
        return rootNode;
    };
    TreeView.prototype.getEndNode = function () {
        var index = this.liList.length - 1;
        var endNode;
        do {
            endNode = this.liList[index];
            index--;
        } while (!isVisible(endNode));
        return endNode;
    };
    TreeView.prototype.setFocus = function (preNode, nextNode) {
        removeClass([preNode], [HOVER, FOCUS]);
        if (!nextNode.classList.contains('e-disable')) {
            addClass([nextNode], [HOVER, FOCUS]);
            this.updateIdAttr(preNode, nextNode);
        }
    };
    TreeView.prototype.updateIdAttr = function (preNode, nextNode) {
        this.element.removeAttribute('aria-activedescendant');
        if (preNode) {
            preNode.removeAttribute('id');
        }
        nextNode.setAttribute('id', this.element.id + '_active');
        this.element.setAttribute('aria-activedescendant', this.element.id + '_active');
    };
    TreeView.prototype.focusIn = function () {
        if (!this.mouseDownStatus) {
            addClass([this.getFocusedNode()], HOVER);
        }
        this.mouseDownStatus = false;
    };
    TreeView.prototype.focusOut = function () {
        removeClass([this.getFocusedNode()], HOVER);
    };
    TreeView.prototype.onMouseOver = function (e) {
        var target = e.target;
        var classList = target.classList;
        var currentLi = closest(target, '.' + LISTITEM);
        if (!currentLi || classList.contains(PARENTITEM) || classList.contains(LISTITEM)) {
            this.removeHover();
            return;
        }
        else {
            if (currentLi && !currentLi.classList.contains('e-disable')) {
                this.setHover(currentLi);
            }
        }
    };
    TreeView.prototype.setHover = function (li) {
        if (!li.classList.contains(HOVER)) {
            this.removeHover();
            addClass([li], HOVER);
        }
    };
    ;
    TreeView.prototype.onMouseLeave = function (e) {
        this.removeHover();
    };
    TreeView.prototype.removeHover = function () {
        var hoveredNode = selectAll('.' + HOVER, this.element);
        if (hoveredNode && hoveredNode.length) {
            removeClass(hoveredNode, HOVER);
        }
    };
    ;
    TreeView.prototype.getNodeData = function (currLi, fromDS) {
        if (!isNOU(currLi) && currLi.classList.contains(LISTITEM) &&
            !isNOU(closest(currLi, '.' + CONTROL)) && closest(currLi, '.' + CONTROL).classList.contains(ROOT)) {
            var id = currLi.getAttribute('data-uid');
            var text = this.getText(currLi, fromDS);
            var pNode = closest(currLi.parentNode, '.' + LISTITEM);
            var pid = pNode ? pNode.getAttribute('data-uid') : null;
            var selected = currLi.classList.contains(ACTIVE);
            var expanded = (currLi.getAttribute('aria-expanded') === 'true') ? true : false;
            var checked = null;
            if (this.showCheckBox) {
                checked = select('.' + CHECKBOXWRAP, currLi).getAttribute('aria-checked');
            }
            return { id: id, text: text, parentID: pid, selected: selected, expanded: expanded, isChecked: checked };
        }
        return { id: '', text: '', parentID: '', selected: '', expanded: '', isChecked: '' };
    };
    TreeView.prototype.getText = function (currLi, fromDS) {
        if (fromDS) {
            var nodeData = this.getNodeObject(currLi.getAttribute('data-uid'));
            var level = parseFloat(currLi.getAttribute('aria-level'));
            var nodeFields = this.getFields(this.fields, level, 1);
            return getValue(nodeFields.text, nodeData);
        }
        return select('.' + LISTTEXT, currLi).textContent;
    };
    TreeView.prototype.getExpandEvent = function (currLi, e) {
        var nodeData = this.getNodeData(currLi);
        return { cancel: false, isInteracted: isNOU(e) ? false : true, node: currLi, nodeData: nodeData, event: e };
    };
    TreeView.prototype.reRenderNodes = function () {
        this.element.innerHTML = '';
        this.setTouchClass();
        this.setProperties({ selectedNodes: [], checkedNodes: [], expandedNodes: [] }, true);
        this.isLoaded = false;
        this.setDataBinding();
    };
    TreeView.prototype.setCssClass = function (oldClass, newClass) {
        if (!isNOU(oldClass) && oldClass !== '') {
            removeClass([this.element], oldClass.split(' '));
        }
        if (!isNOU(newClass) && newClass !== '') {
            addClass([this.element], newClass.split(' '));
        }
    };
    TreeView.prototype.editingHandler = function (e) {
        var target = e.target;
        if (!target || target.classList.contains(ROOT) || target.classList.contains(PARENTITEM) ||
            target.classList.contains(LISTITEM) || target.classList.contains(ICON) ||
            target.classList.contains(INPUT) || target.classList.contains(INPUTGROUP)) {
            return;
        }
        else {
            var liEle = closest(target, '.' + LISTITEM);
            this.createTextbox(liEle, e);
        }
    };
    TreeView.prototype.createTextbox = function (liEle, e) {
        var oldInpEle = select('.' + TREEINPUT, this.element);
        if (oldInpEle) {
            oldInpEle.blur();
        }
        var textEle = select('.' + LISTTEXT, liEle);
        this.updateOldText(liEle);
        var innerEle = this.createElement('input', { className: TREEINPUT, attrs: { value: this.oldText } });
        var eventArgs = this.getEditEvent(liEle, null, innerEle.outerHTML);
        this.trigger('nodeEditing', eventArgs);
        if (eventArgs.cancel) {
            return;
        }
        var inpWidth = textEle.offsetWidth + 5;
        var style = 'width:' + inpWidth + 'px';
        addClass([liEle], EDITING);
        textEle.innerHTML = eventArgs.innerHtml;
        var inpEle = select('.' + TREEINPUT, textEle);
        this.inputObj = Input.createInput({
            element: inpEle,
            properties: {
                enableRtl: this.enableRtl,
            }
        }, this.createElement);
        this.inputObj.container.setAttribute('style', style);
        inpEle.focus();
        var inputEle = inpEle;
        inputEle.setSelectionRange(0, inputEle.value.length);
        this.wireInputEvents(inpEle);
    };
    TreeView.prototype.updateOldText = function (liEle) {
        var id = liEle.getAttribute('data-uid');
        this.editData = this.getNodeObject(id);
        var level = parseFloat(liEle.getAttribute('aria-level'));
        this.editFields = this.getFields(this.fields, level, 1);
        this.oldText = getValue(this.editFields.text, this.editData);
    };
    TreeView.prototype.inputFocusOut = function (e) {
        if (!select('.' + TREEINPUT, this.element)) {
            return;
        }
        var target = e.target;
        var newText = target.value;
        var txtEle = closest(target, '.' + LISTTEXT);
        var liEle = closest(target, '.' + LISTITEM);
        detach(this.inputObj.container);
        this.appendNewText(liEle, txtEle, newText, true);
    };
    TreeView.prototype.appendNewText = function (liEle, txtEle, newText, isInput) {
        var eventArgs = this.getEditEvent(liEle, newText, null);
        this.trigger('nodeEdited', eventArgs);
        newText = eventArgs.cancel ? eventArgs.oldText : eventArgs.newText;
        var newData = setValue(this.editFields.text, newText, this.editData);
        if (!isNOU(this.nodeTemplateFn)) {
            txtEle.innerHTML = '';
            append(this.nodeTemplateFn(newData), txtEle);
        }
        else {
            txtEle.innerHTML = newText;
        }
        if (isInput) {
            removeClass([liEle], EDITING);
            txtEle.focus();
        }
        if (eventArgs.oldText !== newText) {
            this.triggerEvent();
        }
    };
    TreeView.prototype.getElement = function (ele) {
        if (isNOU(ele)) {
            return null;
        }
        else if (typeof ele === 'string') {
            return this.element.querySelector('[data-uid="' + ele + '"]');
        }
        else if (typeof ele === 'object') {
            return ele;
        }
        else {
            return null;
        }
    };
    TreeView.prototype.getId = function (ele) {
        if (isNOU(ele)) {
            return null;
        }
        else if (typeof ele === 'string') {
            return ele;
        }
        else if (typeof ele === 'object') {
            return ele.getAttribute('data-uid');
        }
        else {
            return null;
        }
    };
    TreeView.prototype.getEditEvent = function (liEle, newText, inpEle) {
        var data = this.getNodeData(liEle);
        return { cancel: false, newText: newText, node: liEle, nodeData: data, oldText: this.oldText, innerHtml: inpEle };
    };
    TreeView.prototype.getNodeObject = function (id) {
        var childNodes;
        if (isNOU(id)) {
            return childNodes;
        }
        else if (this.dataType === 1) {
            for (var i = 0, objlen = this.treeData.length; i < objlen; i++) {
                var dataId = getValue(this.fields.id, this.treeData[i]);
                if (!isNOU(this.treeData[i]) && !isNOU(dataId) && dataId.toString() === id) {
                    return this.treeData[i];
                }
            }
        }
        else {
            return this.getChildNodeObject(this.treeData, this.fields, id);
        }
        return childNodes;
    };
    TreeView.prototype.getChildNodeObject = function (obj, mapper, id) {
        var newList;
        if (isNOU(obj)) {
            return newList;
        }
        for (var i = 0, objlen = obj.length; i < objlen; i++) {
            var dataId = getValue(mapper.id, obj[i]);
            if (obj[i] && dataId && dataId.toString() === id) {
                return obj[i];
            }
            else if (typeof mapper.child === 'string' && !isNOU(getValue(mapper.child, obj[i]))) {
                var childData = getValue(mapper.child, obj[i]);
                newList = this.getChildNodeObject(childData, this.getChildMapper(mapper), id);
                if (newList !== undefined) {
                    break;
                }
            }
            else if (this.fields.dataSource instanceof DataManager && !isNOU(getValue('child', obj[i]))) {
                var child = 'child';
                newList = this.getChildNodeObject(getValue(child, obj[i]), this.getChildMapper(mapper), id);
                if (newList !== undefined) {
                    break;
                }
            }
        }
        return newList;
    };
    TreeView.prototype.setDragAndDrop = function (toBind) {
        if (toBind) {
            this.initializeDrag();
        }
        else {
            this.destroyDrag();
        }
    };
    TreeView.prototype.initializeDrag = function () {
        var _this = this;
        var virtualEle;
        var proxy = this;
        this.dragObj = new Draggable(this.element, {
            enableTailMode: true,
            enableAutoScroll: true,
            dragTarget: '.' + TEXTWRAP,
            helper: function (e) {
                _this.dragTarget = e.sender.target;
                var dragRoot = closest(_this.dragTarget, '.' + ROOT);
                var dragWrap = closest(_this.dragTarget, '.' + TEXTWRAP);
                _this.dragLi = closest(_this.dragTarget, '.' + LISTITEM);
                if (_this.fullRowSelect && !dragWrap && _this.dragTarget.classList.contains(FULLROW)) {
                    dragWrap = _this.dragTarget.nextElementSibling;
                }
                if (!_this.dragTarget || !e.element.isSameNode(dragRoot) || !dragWrap ||
                    _this.dragTarget.classList.contains(ROOT) || _this.dragTarget.classList.contains(PARENTITEM) ||
                    _this.dragTarget.classList.contains(LISTITEM) || _this.dragLi.classList.contains('e-disable')) {
                    return false;
                }
                var cloneEle = (dragWrap.cloneNode(true));
                if (isNOU(select('div.' + ICON, cloneEle))) {
                    var icon = proxy.createElement('div', { className: ICON + ' ' + EXPANDABLE });
                    cloneEle.insertBefore(icon, cloneEle.children[0]);
                }
                var cssClass = DRAGITEM + ' ' + ROOT + ' ' + _this.cssClass + ' ' + (_this.enableRtl ? RTL : '');
                virtualEle = proxy.createElement('div', { className: cssClass });
                virtualEle.appendChild(cloneEle);
                var nLen = _this.selectedNodes.length;
                if (nLen > 1 && _this.allowMultiSelection && _this.dragLi.classList.contains(ACTIVE)) {
                    var cNode = proxy.createElement('span', { className: DROPCOUNT, innerHTML: '' + nLen });
                    virtualEle.appendChild(cNode);
                }
                document.body.appendChild(virtualEle);
                document.body.style.cursor = '';
                _this.dragData = _this.getNodeData(_this.dragLi);
                return virtualEle;
            },
            dragStart: function (e) {
                addClass([_this.element], DRAGGING);
                var listItem = closest(e.target, '.e-list-item');
                var level;
                if (listItem) {
                    level = parseInt(listItem.getAttribute('aria-level'), 10);
                }
                var eventArgs = _this.getDragEvent(e.event, _this, null, e.target, null, virtualEle, level);
                if (eventArgs.draggedNode.classList.contains(EDITING)) {
                    eventArgs.cancel = true;
                }
                else {
                    _this.trigger('nodeDragStart', eventArgs);
                }
                if (eventArgs.cancel) {
                    detach(virtualEle);
                    removeClass([_this.element], DRAGGING);
                    _this.dragStartAction = false;
                }
                else {
                    _this.dragStartAction = true;
                }
            },
            drag: function (e) {
                _this.dragObj.setProperties({ cursorAt: { top: (!isNOU(e.event.targetTouches) || Browser.isDevice) ? 60 : -20 } });
                _this.dragAction(e, virtualEle);
            },
            dragStop: function (e) {
                removeClass([_this.element], DRAGGING);
                _this.removeVirtualEle();
                var dropTarget = e.target;
                var preventTargetExpand = false;
                var dropRoot = (closest(dropTarget, '.' + DROPPABLE));
                if (!dropTarget || !dropRoot) {
                    detach(e.helper);
                    document.body.style.cursor = '';
                }
                var listItem = closest(dropTarget, '.e-list-item');
                var level;
                if (listItem) {
                    level = parseInt(listItem.getAttribute('aria-level'), 10);
                }
                var eventArgs = _this.getDragEvent(e.event, _this, dropTarget, dropTarget, null, e.helper, level);
                eventArgs.preventTargetExpand = preventTargetExpand;
                _this.trigger('nodeDragStop', eventArgs);
                _this.dragParent = eventArgs.draggedParentNode;
                _this.preventExpand = eventArgs.preventTargetExpand;
                if (eventArgs.cancel) {
                    if (e.helper.parentNode) {
                        detach(e.helper);
                    }
                    document.body.style.cursor = '';
                }
                _this.dragStartAction = false;
            }
        });
        this.dropObj = new Droppable(this.element, {
            out: function (e) {
                if (!isNOU(e) && !e.target.classList.contains(SIBLING)) {
                    document.body.style.cursor = 'not-allowed';
                }
            },
            over: function (e) {
                document.body.style.cursor = '';
            },
            drop: function (e) {
                _this.dropAction(e);
            }
        });
    };
    TreeView.prototype.dragAction = function (e, virtualEle) {
        var dropRoot = closest(e.target, '.' + DROPPABLE);
        var dropWrap = closest(e.target, '.' + TEXTWRAP);
        var icon = select('div.' + ICON, virtualEle);
        removeClass([icon], [DROPIN, DROPNEXT, DROPOUT, NODROP]);
        this.removeVirtualEle();
        document.body.style.cursor = '';
        var classList = e.target.classList;
        if (this.fullRowSelect && !dropWrap && !isNOU(classList) && classList.contains(FULLROW)) {
            dropWrap = e.target.nextElementSibling;
        }
        if (dropRoot) {
            var dropLi = closest(e.target, '.' + LISTITEM);
            if (!dropRoot.classList.contains(ROOT) || (dropWrap &&
                (!dropLi.isSameNode(this.dragLi) && !this.isDescendant(this.dragLi, dropLi)))) {
                if (dropLi && e && (e.event.offsetY < 7)) {
                    addClass([icon], DROPNEXT);
                    var virEle = this.createElement('div', { className: SIBLING });
                    var index = this.fullRowSelect ? (1) : (0);
                    dropLi.insertBefore(virEle, dropLi.children[index]);
                }
                else if (dropLi && e && (e.target.offsetHeight > 0 && e.event.offsetY > (e.target.offsetHeight - 10))) {
                    addClass([icon], DROPNEXT);
                    var virEle = this.createElement('div', { className: SIBLING });
                    var index = this.fullRowSelect ? (2) : (1);
                    dropLi.insertBefore(virEle, dropLi.children[index]);
                }
                else {
                    addClass([icon], DROPIN);
                }
            }
            else if (e.target.nodeName === 'LI' && (!dropLi.isSameNode(this.dragLi) && !this.isDescendant(this.dragLi, dropLi))) {
                addClass([icon], DROPNEXT);
                this.renderVirtualEle(e);
            }
            else if (e.target.classList.contains(SIBLING)) {
                addClass([icon], DROPNEXT);
            }
            else {
                addClass([icon], DROPOUT);
            }
        }
        else {
            addClass([icon], NODROP);
            document.body.style.cursor = 'not-allowed';
        }
        var listItem = closest(e.target, '.e-list-item');
        var level;
        if (listItem) {
            level = parseInt(listItem.getAttribute('aria-level'), 10);
        }
        var eventArgs = this.getDragEvent(e.event, this, e.target, e.target, null, virtualEle, level);
        if (eventArgs.dropIndicator) {
            removeClass([icon], eventArgs.dropIndicator);
        }
        this.trigger('nodeDragging', eventArgs);
        if (eventArgs.dropIndicator) {
            addClass([icon], eventArgs.dropIndicator);
        }
    };
    TreeView.prototype.dropAction = function (e) {
        var offsetY = e.event.offsetY;
        var dropTarget = e.target;
        var dragObj;
        var level;
        var drop = false;
        var dragInstance = e.dragData.draggable;
        for (var i = 0; i < dragInstance.ej2_instances.length; i++) {
            if (dragInstance.ej2_instances[i] instanceof TreeView_1) {
                dragObj = dragInstance.ej2_instances[i];
                break;
            }
        }
        if (dragObj && dragObj.dragTarget) {
            var dragTarget = dragObj.dragTarget;
            var dragLi = (closest(dragTarget, '.' + LISTITEM));
            var dropLi = (closest(dropTarget, '.' + LISTITEM));
            if (dropLi == null && dropTarget.classList.contains(ROOT)) {
                dropLi = dropTarget.firstElementChild;
            }
            detach(e.droppedElement);
            document.body.style.cursor = '';
            if (!dropLi || dropLi.isSameNode(dragLi) || this.isDescendant(dragLi, dropLi)) {
                if (this.fields.dataSource instanceof DataManager === false) {
                    this.preventExpand = false;
                }
                return;
            }
            if (dragObj.allowMultiSelection && dragLi.classList.contains(ACTIVE)) {
                var sNodes = selectAll('.' + ACTIVE, dragObj.element);
                for (var i = 0; i < sNodes.length; i++) {
                    if (dropLi.isSameNode(sNodes[i]) || this.isDescendant(sNodes[i], dropLi)) {
                        continue;
                    }
                    this.appendNode(dropTarget, sNodes[i], dropLi, e, dragObj, offsetY);
                }
            }
            else {
                this.appendNode(dropTarget, dragLi, dropLi, e, dragObj, offsetY);
            }
            level = parseInt(dragLi.getAttribute('aria-level'), 10);
            drop = true;
        }
        if (this.fields.dataSource instanceof DataManager === false) {
            this.preventExpand = false;
        }
        this.trigger('nodeDropped', this.getDragEvent(e.event, dragObj, dropTarget, e.target, e.dragData.draggedElement, null, level, drop));
        this.triggerEvent();
    };
    TreeView.prototype.appendNode = function (dropTarget, dragLi, dropLi, e, dragObj, offsetY) {
        if (!dragLi.classList.contains('e-disable') && !dropLi.classList.contains('e-disable')) {
            if (dropTarget.nodeName === 'LI') {
                this.dropAsSiblingNode(dragLi, dropLi, e, dragObj);
            }
            else if (dropTarget.firstElementChild && dropTarget.classList.contains(ROOT)) {
                if (dropTarget.firstElementChild.nodeName === 'UL') {
                    this.dropAsSiblingNode(dragLi, dropLi, e, dragObj);
                }
            }
            else {
                this.dropAsChildNode(dragLi, dropLi, dragObj, null, e, offsetY);
            }
        }
    };
    TreeView.prototype.dropAsSiblingNode = function (dragLi, dropLi, e, dragObj) {
        var dropUl = closest(dropLi, '.' + PARENTITEM);
        var dragParentUl = closest(dragLi, '.' + PARENTITEM);
        var dragParentLi = closest(dragParentUl, '.' + LISTITEM);
        var pre;
        if (e.target.offsetHeight > 0 && e.event.offsetY > e.target.offsetHeight - 2) {
            pre = false;
        }
        else if (e.event.offsetY < 2) {
            pre = true;
        }
        dropUl.insertBefore(dragLi, pre ? e.target : e.target.nextElementSibling);
        this.moveData(dragLi, dropLi, dropUl, pre, dragObj);
        this.updateElement(dragParentUl, dragParentLi);
        this.updateAriaLevel(dragLi);
        if (dragObj.element.id === this.element.id) {
            this.updateList();
        }
        else {
            dragObj.updateInstance();
            this.updateInstance();
        }
    };
    TreeView.prototype.dropAsChildNode = function (dragLi, dropLi, dragObj, index, e, pos) {
        var dragParentUl = closest(dragLi, '.' + PARENTITEM);
        var dragParentLi = closest(dragParentUl, '.' + LISTITEM);
        var dropParentUl = closest(dropLi, '.' + PARENTITEM);
        if (e && (pos < 7)) {
            dropParentUl.insertBefore(dragLi, dropLi);
            this.moveData(dragLi, dropLi, dropParentUl, true, dragObj);
        }
        else if (e && (e.target.offsetHeight > 0 && pos > (e.target.offsetHeight - 10))) {
            dropParentUl.insertBefore(dragLi, dropLi.nextElementSibling);
            this.moveData(dragLi, dropLi, dropParentUl, false, dragObj);
        }
        else {
            var dropUl = this.expandParent(dropLi);
            var childLi = dropUl.childNodes[index];
            dropUl.insertBefore(dragLi, childLi);
            this.moveData(dragLi, childLi, dropUl, true, dragObj);
        }
        this.updateElement(dragParentUl, dragParentLi);
        this.updateAriaLevel(dragLi);
        if (dragObj.element.id === this.element.id) {
            this.updateList();
        }
        else {
            dragObj.updateInstance();
            this.updateInstance();
        }
    };
    TreeView.prototype.moveData = function (dragLi, dropLi, dropUl, pre, dragObj) {
        var dropParentLi = closest(dropUl, '.' + LISTITEM);
        var id = this.getId(dragLi);
        var removedData = dragObj.updateChildField(dragObj.treeData, dragObj.fields, id, null, null, true);
        var refId = this.getId(dropLi);
        var index = this.getDataPos(this.treeData, this.fields, refId);
        var parentId = this.getId(dropParentLi);
        if (this.dataType === 1) {
            this.updateField(this.treeData, this.fields, parentId, 'hasChildren', true);
            var pos = isNOU(index) ? this.treeData.length : (pre ? index : index + 1);
            if (isNOU(parentId) && !this.hasPid) {
                delete removedData[0][this.fields.parentID];
            }
            else {
                var currPid = this.isNumberTypeId ? parseFloat(parentId) : parentId;
                setValue(this.fields.parentID, currPid, removedData[0]);
            }
            this.treeData.splice(pos, 0, removedData[0]);
            if (dragObj.element.id !== this.element.id) {
                var childData = dragObj.removeChildNodes(id);
                pos++;
                for (var i = 0, len = childData.length; i < len; i++) {
                    this.treeData.splice(pos, 0, childData[i]);
                    pos++;
                }
                dragObj.groupedData = dragObj.getGroupedData(dragObj.treeData, dragObj.fields.parentID);
            }
            this.groupedData = this.getGroupedData(this.treeData, this.fields.parentID);
        }
        else {
            this.addChildData(this.treeData, this.fields, parentId, removedData, pre ? index : index + 1);
        }
    };
    TreeView.prototype.expandParent = function (dropLi) {
        var dropIcon = select('div.' + ICON, dropLi);
        if (dropIcon && dropIcon.classList.contains(EXPANDABLE) && this.preventExpand !== true) {
            this.expandAction(dropLi, dropIcon, null);
        }
        var dropUl = select('.' + PARENTITEM, dropLi);
        if (this.preventExpand === true && !dropUl && dropIcon) {
            this.renderChildNodes(dropLi);
        }
        dropUl = select('.' + PARENTITEM, dropLi);
        if (!isNOU(dropUl) && this.preventExpand === true) {
            dropUl.style.display = 'none';
        }
        if (!isNOU(dropUl) && this.preventExpand === false) {
            dropUl.style.display = 'block';
        }
        if (isNOU(dropUl) && this.preventExpand === true) {
            if (isNOU(dropIcon)) {
                ListBase.generateIcon(this.createElement, dropLi, EXPANDABLE, this.listBaseOption);
            }
            var icon = select('div.' + ICON, dropLi);
            if (icon) {
                icon.classList.add('e-icon-expandable');
            }
            dropUl = ListBase.generateUL(this.createElement, [], null, this.listBaseOption);
            dropLi.appendChild(dropUl);
            if (icon) {
                removeClass([icon], COLLAPSIBLE);
            }
            else {
                ListBase.generateIcon(this.createElement, dropLi, EXPANDABLE, this.listBaseOption);
            }
            dropLi.setAttribute('aria-expanded', 'false');
            dropUl.style.display = 'none';
        }
        if (isNOU(dropUl)) {
            this.trigger('nodeExpanding', this.getExpandEvent(dropLi, null));
            if (isNOU(dropIcon)) {
                ListBase.generateIcon(this.createElement, dropLi, COLLAPSIBLE, this.listBaseOption);
            }
            var icon = select('div.' + ICON, dropLi);
            if (icon) {
                removeClass([icon], EXPANDABLE);
            }
            else {
                ListBase.generateIcon(this.createElement, dropLi, COLLAPSIBLE, this.listBaseOption);
                icon = select('div.' + ICON, dropLi);
                removeClass([icon], EXPANDABLE);
            }
            dropUl = ListBase.generateUL(this.createElement, [], null, this.listBaseOption);
            dropLi.appendChild(dropUl);
            this.addExpand(dropLi);
            this.trigger('nodeExpanded', this.getExpandEvent(dropLi, null));
        }
        return dropUl;
    };
    TreeView.prototype.updateElement = function (dragParentUl, dragParentLi) {
        if (dragParentLi && dragParentUl.childElementCount === 0) {
            var dragIcon = select('div.' + ICON, dragParentLi);
            detach(dragParentUl);
            detach(dragIcon);
            var parentId = this.getId(dragParentLi);
            this.updateField(this.treeData, this.fields, parentId, 'hasChildren', null);
            this.removeExpand(dragParentLi, true);
        }
    };
    TreeView.prototype.updateAriaLevel = function (dragLi) {
        var level = this.parents(dragLi, '.' + PARENTITEM).length;
        dragLi.setAttribute('aria-level', '' + level);
        this.updateChildAriaLevel(select('.' + PARENTITEM, dragLi), level + 1);
    };
    TreeView.prototype.updateChildAriaLevel = function (element, level) {
        if (!isNOU(element)) {
            var cNodes = element.childNodes;
            for (var i = 0, len = cNodes.length; i < len; i++) {
                var liEle = cNodes[i];
                liEle.setAttribute('aria-level', '' + level);
                this.updateChildAriaLevel(select('.' + PARENTITEM, liEle), level + 1);
            }
        }
    };
    TreeView.prototype.renderVirtualEle = function (e) {
        var pre;
        if (e.event.offsetY > e.target.offsetHeight - 2) {
            pre = false;
        }
        else if (e.event.offsetY < 2) {
            pre = true;
        }
        var virEle = this.createElement('div', { className: SIBLING });
        var index = this.fullRowSelect ? (pre ? 1 : 2) : (pre ? 0 : 1);
        e.target.insertBefore(virEle, e.target.children[index]);
    };
    TreeView.prototype.removeVirtualEle = function () {
        var sibEle = select('.' + SIBLING);
        if (sibEle) {
            detach(sibEle);
        }
    };
    TreeView.prototype.destroyDrag = function () {
        if (this.dragObj && this.dropObj) {
            this.dragObj.destroy();
            this.dropObj.destroy();
        }
    };
    TreeView.prototype.getDragEvent = function (event, obj, dropTarget, target, dragNode, cloneEle, level, drop) {
        var dropLi = dropTarget ? closest(dropTarget, '.' + LISTITEM) : null;
        var dropData = dropLi ? this.getNodeData(dropLi) : null;
        var draggedNode = obj ? obj.dragLi : dragNode;
        var draggedNodeData = obj ? obj.dragData : null;
        var newParent = dropTarget ? this.parents(dropTarget, '.' + LISTITEM) : null;
        var dragLiParent = obj.dragLi.parentElement;
        var dragParent = obj.dragLi ? closest(dragLiParent, '.' + LISTITEM) : null;
        var targetParent = null;
        var indexValue = null;
        var iconCss = [DROPNEXT, DROPIN, DROPOUT, NODROP];
        var iconClass = null;
        var node = (drop === true) ? draggedNode : dropLi;
        var index = node ? closest(node, '.e-list-parent') : null;
        var i = 0;
        dragParent = (obj.dragLi && dragParent === null) ? closest(dragLiParent, '.' + ROOT) : dragParent;
        dragParent = (drop === true) ? this.dragParent : dragParent;
        if (cloneEle) {
            while (i < 4) {
                if (select('.' + ICON, cloneEle).classList.contains(iconCss[i])) {
                    iconClass = iconCss[i];
                    break;
                }
                i++;
            }
        }
        if (index) {
            var dropTar = 0;
            for (i = 0; i < index.childElementCount; i++) {
                dropTar = (drop !== true && index.children[i] === draggedNode && dropLi !== draggedNode) ? ++dropTar : dropTar;
                if ((drop !== true && index.children[i].classList.contains('e-hover'))) {
                    indexValue = (event.offsetY >= 23) ? i + 1 : i;
                    break;
                }
                else if (index.children[i] === node) {
                    indexValue = (event.offsetY >= 23) ? i : i;
                    break;
                }
            }
            indexValue = (dropTar !== 0) ? --indexValue : indexValue;
        }
        if (dropTarget) {
            if (newParent.length === 0) {
                targetParent = null;
            }
            else if (dropTarget.classList.contains(LISTITEM)) {
                targetParent = newParent[0];
            }
            else {
                targetParent = newParent[1];
            }
        }
        if (dropLi === draggedNode) {
            targetParent = dropLi;
        }
        if (dropTarget && target.offsetHeight <= 33 && event.offsetY < target.offsetHeight - 10 && event.offsetY > 6) {
            targetParent = dropLi;
            if (drop !== true) {
                level = ++level;
                var parent_1 = targetParent ? select('.e-list-parent', targetParent) : null;
                indexValue = (parent_1) ? parent_1.children.length : 0;
                if (!(this.fields.dataSource instanceof DataManager) && parent_1 === null && targetParent) {
                    var parent_2 = targetParent.hasAttribute('data-uid') ?
                        this.getChildNodes(this.fields.dataSource, targetParent.getAttribute('data-uid').toString()) : null;
                    indexValue = (parent_2) ? parent_2.length : 0;
                }
            }
        }
        return {
            cancel: false,
            clonedNode: cloneEle,
            event: event,
            draggedNode: draggedNode,
            draggedNodeData: draggedNodeData,
            droppedNode: dropLi,
            droppedNodeData: dropData,
            dropIndex: indexValue,
            dropLevel: level,
            draggedParentNode: dragParent,
            dropTarget: targetParent,
            dropIndicator: iconClass,
            target: target,
        };
    };
    TreeView.prototype.addFullRow = function (toAdd) {
        var len = this.liList.length;
        if (toAdd) {
            for (var i = 0; i < len; i++) {
                this.createFullRow(this.liList[i]);
            }
        }
        else {
            for (var i = 0; i < len; i++) {
                var rowDiv = select('.' + FULLROW, this.liList[i]);
                detach(rowDiv);
            }
        }
    };
    TreeView.prototype.createFullRow = function (item) {
        var rowDiv = this.createElement('div', { className: FULLROW });
        item.insertBefore(rowDiv, item.childNodes[0]);
    };
    TreeView.prototype.addMultiSelect = function (toAdd) {
        if (toAdd) {
            var liEles = selectAll('.' + LISTITEM + ':not([aria-selected="true"])', this.element);
            for (var _i = 0, liEles_1 = liEles; _i < liEles_1.length; _i++) {
                var ele = liEles_1[_i];
                ele.setAttribute('aria-selected', 'false');
            }
        }
        else {
            var liEles = selectAll('.' + LISTITEM + '[aria-selected="false"]', this.element);
            for (var _a = 0, liEles_2 = liEles; _a < liEles_2.length; _a++) {
                var ele = liEles_2[_a];
                ele.removeAttribute('aria-selected');
            }
        }
    };
    TreeView.prototype.collapseByLevel = function (element, level, excludeHiddenNodes) {
        if (level > 0 && !isNOU(element)) {
            var cNodes = this.getVisibleNodes(excludeHiddenNodes, element.childNodes);
            for (var i = 0, len = cNodes.length; i < len; i++) {
                var liEle = cNodes[i];
                var icon = select('.' + COLLAPSIBLE, select('.' + TEXTWRAP, liEle));
                if (!isNOU(icon)) {
                    this.collapseNode(liEle, icon, null);
                }
                this.collapseByLevel(select('.' + PARENTITEM, liEle), level - 1, excludeHiddenNodes);
            }
        }
    };
    TreeView.prototype.collapseAllNodes = function (excludeHiddenNodes) {
        var cIcons = this.getVisibleNodes(excludeHiddenNodes, selectAll('.' + COLLAPSIBLE, this.element));
        for (var i = 0, len = cIcons.length; i < len; i++) {
            var icon = cIcons[i];
            var liEle = closest(icon, '.' + LISTITEM);
            this.collapseNode(liEle, icon, null);
        }
    };
    TreeView.prototype.expandByLevel = function (element, level, excludeHiddenNodes) {
        if (level > 0 && !isNOU(element)) {
            var eNodes = this.getVisibleNodes(excludeHiddenNodes, element.childNodes);
            for (var i = 0, len = eNodes.length; i < len; i++) {
                var liEle = eNodes[i];
                var icon = select('.' + EXPANDABLE, select('.' + TEXTWRAP, liEle));
                if (!isNOU(icon)) {
                    this.expandAction(liEle, icon, null);
                }
                this.expandByLevel(select('.' + PARENTITEM, liEle), level - 1, excludeHiddenNodes);
            }
        }
    };
    TreeView.prototype.expandAllNodes = function (excludeHiddenNodes) {
        var eIcons = this.getVisibleNodes(excludeHiddenNodes, selectAll('.' + EXPANDABLE, this.element));
        for (var i = 0, len = eIcons.length; i < len; i++) {
            var icon = eIcons[i];
            var liEle = closest(icon, '.' + LISTITEM);
            this.expandAction(liEle, icon, null, true);
        }
    };
    TreeView.prototype.getVisibleNodes = function (excludeHiddenNodes, nodes) {
        var vNodes = Array.prototype.slice.call(nodes);
        if (excludeHiddenNodes) {
            for (var i = 0; i < vNodes.length; i++) {
                if (!isVisible(vNodes[i])) {
                    vNodes.splice(i, 1);
                    i--;
                }
            }
        }
        return vNodes;
    };
    TreeView.prototype.removeNode = function (node) {
        var dragParentUl = closest(node, '.' + PARENTITEM);
        var dragParentLi = closest(dragParentUl, '.' + LISTITEM);
        detach(node);
        this.updateElement(dragParentUl, dragParentLi);
        this.updateInstance();
        this.removeData(node);
    };
    TreeView.prototype.updateInstance = function () {
        this.updateList();
        this.updateSelectedNodes();
        this.updateExpandedNodes();
    };
    TreeView.prototype.updateList = function () {
        this.liList = Array.prototype.slice.call(selectAll('.' + LISTITEM, this.element));
    };
    TreeView.prototype.updateSelectedNodes = function () {
        this.setProperties({ selectedNodes: [] }, true);
        var sNodes = selectAll('.' + ACTIVE, this.element);
        this.selectGivenNodes(sNodes);
    };
    TreeView.prototype.updateExpandedNodes = function () {
        this.setProperties({ expandedNodes: [] }, true);
        var eNodes = selectAll('[aria-expanded="true"]', this.element);
        for (var i = 0, len = eNodes.length; i < len; i++) {
            this.addExpand(eNodes[i]);
        }
    };
    TreeView.prototype.removeData = function (node) {
        if (this.dataType === 1) {
            var dm = new DataManager(this.treeData);
            var id = this.getId(node);
            var data = {};
            var newId = this.isNumberTypeId ? parseFloat(id) : id;
            data[this.fields.id] = newId;
            dm.remove(this.fields.id, data);
            this.removeChildNodes(id);
        }
        else {
            var id = this.getId(node);
            this.updateChildField(this.treeData, this.fields, id, null, null, true);
        }
    };
    TreeView.prototype.removeChildNodes = function (parentId) {
        var cNodes = this.getChildGroup(this.groupedData, parentId, false);
        var childData = [];
        if (cNodes) {
            for (var i = 0, len = cNodes.length; i < len; i++) {
                var dm = new DataManager(this.treeData);
                var id = getValue(this.fields.id, cNodes[i]).toString();
                var data = {};
                var currId = this.isNumberTypeId ? parseFloat(id) : id;
                data[this.fields.id] = currId;
                var nodeData = dm.remove(this.fields.id, data);
                childData.push(nodeData[0]);
                this.removeChildNodes(id);
            }
        }
        return childData;
    };
    TreeView.prototype.doGivenAction = function (nodes, selector, toExpand) {
        for (var i = 0, len = nodes.length; i < len; i++) {
            var liEle = this.getElement(nodes[i]);
            if (isNOU(liEle)) {
                continue;
            }
            var icon = select('.' + selector, select('.' + TEXTWRAP, liEle));
            if (!isNOU(icon)) {
                toExpand ? this.expandAction(liEle, icon, null) : this.collapseNode(liEle, icon, null);
            }
        }
    };
    TreeView.prototype.addGivenNodes = function (nodes, dropLi, index, isRemote, dropEle) {
        if (nodes.length === 0) {
            return;
        }
        var sNodes = this.getSortedData(nodes);
        var level = dropLi ? parseFloat(dropLi.getAttribute('aria-level')) + 1 : 1;
        if (isRemote) {
            this.updateMapper(level);
        }
        var li = ListBase.createListItemFromJson(this.createElement, sNodes, this.listBaseOption, level);
        var dropUl;
        if (!dropEle) {
            dropUl = dropLi ? this.expandParent(dropLi) : select('.' + PARENTITEM, this.element);
        }
        else {
            dropUl = dropEle;
        }
        var refNode = dropUl.childNodes[index];
        for (var i = 0; i < li.length; i++) {
            dropUl.insertBefore(li[i], refNode);
        }
        var id = this.getId(dropLi);
        if (this.dataType === 1) {
            this.updateField(this.treeData, this.fields, id, 'hasChildren', true);
            var refId = this.getId(refNode);
            var pos = isNOU(refId) ? this.treeData.length : this.getDataPos(this.treeData, this.fields, refId);
            for (var j = 0; j < nodes.length; j++) {
                if (!isNOU(id)) {
                    var currId = this.isNumberTypeId ? parseFloat(id) : id;
                    setValue(this.fields.parentID, currId, nodes[j]);
                }
                this.treeData.splice(pos, 0, nodes[j]);
                pos++;
            }
        }
        else {
            this.addChildData(this.treeData, this.fields, id, nodes, index);
        }
        this.finalizeNode(dropUl);
    };
    TreeView.prototype.updateMapper = function (level) {
        var mapper = (level === 1) ? this.fields : this.getChildFields(this.fields, level - 1, 1);
        this.updateListProp(mapper);
    };
    TreeView.prototype.updateListProp = function (mapper) {
        var prop = this.getActualProperties(mapper);
        this.listBaseOption.fields = prop;
        this.listBaseOption.fields.url = prop.hasOwnProperty('navigateUrl') ? prop.navigateUrl : 'navigateUrl';
    };
    TreeView.prototype.getDataPos = function (obj, mapper, id) {
        var pos = null;
        for (var i = 0, objlen = obj.length; i < objlen; i++) {
            var nodeId = getValue(mapper.id, obj[i]);
            if (obj[i] && nodeId && nodeId.toString() === id) {
                return i;
            }
            else if (typeof mapper.child === 'string' && !isNOU(getValue(mapper.child, obj[i]))) {
                var data = getValue(mapper.child, obj[i]);
                pos = this.getDataPos(data, this.getChildMapper(mapper), id);
                if (pos !== null) {
                    break;
                }
            }
            else if (this.fields.dataSource instanceof DataManager && !isNOU(getValue('child', obj[i]))) {
                var items = getValue('child', obj[i]);
                pos = this.getDataPos(items, this.getChildMapper(mapper), id);
                if (pos !== null) {
                    break;
                }
            }
        }
        return pos;
    };
    TreeView.prototype.addChildData = function (obj, mapper, id, data, index) {
        var updated;
        if (isNOU(id)) {
            index = isNOU(index) ? obj.length : index;
            for (var k = 0, len = data.length; k < len; k++) {
                obj.splice(index, 0, data[k]);
                index++;
            }
            return updated;
        }
        for (var i = 0, objlen = obj.length; i < objlen; i++) {
            var nodeId = getValue(mapper.id, obj[i]);
            if (obj[i] && nodeId && nodeId.toString() === id) {
                if ((typeof mapper.child === 'string' && obj[i].hasOwnProperty(mapper.child)) ||
                    (this.fields.dataSource instanceof DataManager && obj[i].hasOwnProperty('child'))) {
                    var key = (typeof mapper.child === 'string') ? mapper.child : 'child';
                    var childData = getValue(key, obj[i]);
                    index = isNOU(index) ? childData.length : index;
                    for (var k = 0, len = data.length; k < len; k++) {
                        childData.splice(index, 0, data[k]);
                        index++;
                    }
                }
                else {
                    var key = (typeof mapper.child === 'string') ? mapper.child : 'child';
                    obj[i][key] = data;
                }
                return true;
            }
            else if (typeof mapper.child === 'string' && !isNOU(getValue(mapper.child, obj[i]))) {
                var childObj = getValue(mapper.child, obj[i]);
                updated = this.addChildData(childObj, this.getChildMapper(mapper), id, data, index);
                if (updated !== undefined) {
                    break;
                }
            }
            else if (this.fields.dataSource instanceof DataManager && !isNOU(getValue('child', obj[i]))) {
                var childData = getValue('child', obj[i]);
                updated = this.addChildData(childData, this.getChildMapper(mapper), id, data, index);
                if (updated !== undefined) {
                    break;
                }
            }
        }
        return updated;
    };
    TreeView.prototype.doDisableAction = function (nodes) {
        for (var i = 0, len = nodes.length; i < len; i++) {
            var liEle = this.getElement(nodes[i]);
            if (isNOU(liEle)) {
                var id = void 0;
                id = (nodes[i]) ? nodes[i].toString() : null;
                if (id && this.disableNode.indexOf(nodes[i].toString()) === -1) {
                    this.disableNode.push(nodes[i].toString());
                }
                continue;
            }
            liEle.setAttribute('aria-disabled', 'true');
            addClass([liEle], DISABLE);
        }
    };
    TreeView.prototype.doEnableAction = function (nodes) {
        for (var i = 0, len = nodes.length; i < len; i++) {
            var liEle = this.getElement(nodes[i]);
            if (isNOU(liEle)) {
                var id = (nodes[i]) ? nodes[i].toString() : null;
                if (id && this.disableNode.indexOf(id) !== -1) {
                    this.disableNode.splice(this.disableNode.indexOf(id), 1);
                }
                continue;
            }
            liEle.removeAttribute('aria-disabled');
            removeClass([liEle], DISABLE);
        }
    };
    TreeView.prototype.setTouchClass = function () {
        var ele = closest(this.element, '.' + BIGGER);
        this.touchClass = isNOU(ele) ? '' : SMALL;
    };
    TreeView.prototype.updatePersistProp = function () {
        this.removeField(this.treeData, this.fields, ['selected', 'expanded']);
        var sleNodes = this.selectedNodes;
        for (var l = 0, slelen = sleNodes.length; l < slelen; l++) {
            this.updateField(this.treeData, this.fields, sleNodes[l], 'selected', true);
        }
        var enodes = this.expandedNodes;
        for (var k = 0, nodelen = enodes.length; k < nodelen; k++) {
            this.updateField(this.treeData, this.fields, enodes[k], 'expanded', true);
        }
        if (this.showCheckBox) {
            this.removeField(this.treeData, this.fields, ['isChecked']);
            var cnodes = this.checkedNodes;
            for (var m = 0, nodelen = cnodes.length; m < nodelen; m++) {
                this.updateField(this.treeData, this.fields, cnodes[m], 'isChecked', true);
            }
        }
    };
    TreeView.prototype.removeField = function (obj, mapper, names) {
        if (isNOU(obj) || isNOU(mapper)) {
            return;
        }
        for (var i = 0, objlen = obj.length; i < objlen; i++) {
            for (var j = 0; j < names.length; j++) {
                var field = this.getMapperProp(mapper, names[j]);
                if (!isNOU(obj[i][field])) {
                    delete obj[i][field];
                }
            }
            if (typeof mapper.child === 'string' && !isNOU(getValue(mapper.child, obj[i]))) {
                this.removeField(getValue(mapper.child, obj[i]), this.getChildMapper(mapper), names);
            }
            else if (this.fields.dataSource instanceof DataManager && !isNOU(getValue('child', obj[i]))) {
                this.removeField(getValue('child', obj[i]), this.getChildMapper(mapper), names);
            }
        }
    };
    TreeView.prototype.getMapperProp = function (mapper, fieldName) {
        switch (fieldName) {
            case 'selected':
                return !isNOU(mapper.selected) ? mapper.selected : 'selected';
            case 'expanded':
                return !isNOU(mapper.expanded) ? mapper.expanded : 'expanded';
            case 'isChecked':
                return !isNOU(mapper.isChecked) ? mapper.isChecked : 'isChecked';
            case 'hasChildren':
                return !isNOU(mapper.hasChildren) ? mapper.hasChildren : 'hasChildren';
            default:
                return fieldName;
        }
    };
    TreeView.prototype.updateField = function (obj, mapper, id, key, value) {
        var childNodes;
        if (isNOU(id)) {
            return;
        }
        else if (this.dataType === 1) {
            var newId = this.isNumberTypeId ? parseFloat(id) : id;
            var resultData = new DataManager(this.treeData).executeLocal(new Query().where(mapper.id, 'equal', newId, false));
            setValue(this.getMapperProp(mapper, key), value, resultData[0]);
        }
        else {
            this.updateChildField(obj, mapper, id, key, value);
        }
    };
    TreeView.prototype.updateChildField = function (obj, mapper, id, key, value, remove) {
        var removedData;
        if (isNOU(obj)) {
            return removedData;
        }
        for (var i = 0, objlen = obj.length; i < objlen; i++) {
            var nodeId = getValue(mapper.id, obj[i]);
            if (obj[i] && nodeId && nodeId.toString() === id) {
                if (remove) {
                    removedData = obj.splice(i, 1);
                }
                else {
                    setValue(this.getMapperProp(mapper, key), value, obj[i]);
                    removedData = [];
                }
                return removedData;
            }
            else if (typeof mapper.child === 'string' && !isNOU(getValue(mapper.child, obj[i]))) {
                var childData = getValue(mapper.child, obj[i]);
                removedData = this.updateChildField(childData, this.getChildMapper(mapper), id, key, value, remove);
                if (removedData !== undefined) {
                    break;
                }
            }
            else if (this.fields.dataSource instanceof DataManager && !isNOU(getValue('child', obj[i]))) {
                var childItems = getValue('child', obj[i]);
                removedData = this.updateChildField(childItems, this.getChildMapper(mapper), id, key, value, remove);
                if (removedData !== undefined) {
                    break;
                }
            }
        }
        return removedData;
    };
    TreeView.prototype.triggerEvent = function () {
        var eventArgs = { data: this.treeData };
        this.trigger('dataSourceChanged', eventArgs);
    };
    TreeView.prototype.wireInputEvents = function (inpEle) {
        EventHandler.add(inpEle, 'blur', this.inputFocusOut, this);
    };
    TreeView.prototype.wireEditingEvents = function (toBind) {
        if (toBind) {
            var proxy_2 = this;
            this.touchEditObj = new Touch(this.element, {
                tap: function (e) {
                    if (e.tapCount === 2) {
                        e.originalEvent.preventDefault();
                        proxy_2.editingHandler(e.originalEvent);
                    }
                }
            });
        }
        else {
            if (this.touchEditObj) {
                this.touchEditObj.destroy();
            }
        }
    };
    TreeView.prototype.wireClickEvent = function (toBind) {
        if (toBind) {
            var proxy_3 = this;
            this.touchClickObj = new Touch(this.element, {
                tap: function (e) {
                    e.originalEvent.preventDefault();
                    proxy_3.clickHandler(e);
                }
            });
        }
        else {
            if (this.touchClickObj) {
                this.touchClickObj.destroy();
            }
        }
    };
    TreeView.prototype.wireExpandOnEvent = function (toBind) {
        var _this = this;
        if (toBind) {
            var proxy_4 = this;
            this.touchExpandObj = new Touch(this.element, {
                tap: function (e) {
                    if (_this.expandOnType === 'Click' || (_this.expandOnType === 'DblClick' && e.tapCount === 2)) {
                        proxy_4.expandHandler(e);
                    }
                }
            });
        }
        else {
            if (this.touchExpandObj) {
                this.touchExpandObj.destroy();
            }
        }
    };
    TreeView.prototype.mouseDownHandler = function (e) {
        this.mouseDownStatus = true;
        if (e.shiftKey || e.ctrlKey) {
            e.preventDefault();
        }
        if (e.ctrlKey && this.allowMultiSelection) {
            EventHandler.add(this.element, 'contextmenu', this.preventContextMenu, this);
        }
    };
    ;
    TreeView.prototype.preventContextMenu = function (e) {
        e.preventDefault();
    };
    TreeView.prototype.wireEvents = function () {
        EventHandler.add(this.element, 'mousedown', this.mouseDownHandler, this);
        this.wireClickEvent(true);
        if (this.expandOnType !== 'None') {
            this.wireExpandOnEvent(true);
        }
        EventHandler.add(this.element, 'focus', this.focusIn, this);
        EventHandler.add(this.element, 'blur', this.focusOut, this);
        EventHandler.add(this.element, 'mouseover', this.onMouseOver, this);
        EventHandler.add(this.element, 'mouseout', this.onMouseLeave, this);
        this.keyboardModule = new KeyboardEvents(this.element, {
            keyAction: this.keyActionHandler.bind(this),
            keyConfigs: this.keyConfigs,
            eventName: 'keydown',
        });
    };
    TreeView.prototype.unWireEvents = function () {
        EventHandler.remove(this.element, 'mousedown', this.mouseDownHandler);
        this.wireClickEvent(false);
        this.wireExpandOnEvent(false);
        EventHandler.remove(this.element, 'focus', this.focusIn);
        EventHandler.remove(this.element, 'blur', this.focusOut);
        EventHandler.remove(this.element, 'mouseover', this.onMouseOver);
        EventHandler.remove(this.element, 'mouseout', this.onMouseLeave);
        this.keyboardModule.destroy();
    };
    TreeView.prototype.parents = function (element, selector) {
        var matched = [];
        var el = element.parentNode;
        while (!isNOU(el)) {
            if (matches(el, selector)) {
                matched.push(el);
            }
            el = el.parentNode;
        }
        return matched;
    };
    TreeView.prototype.isDescendant = function (parent, child) {
        var node = child.parentNode;
        while (!isNOU(node)) {
            if (node === parent) {
                return true;
            }
            node = node.parentNode;
        }
        return false;
    };
    TreeView.prototype.showSpinner = function (element) {
        addClass([element], LOAD);
        createSpinner({
            target: element,
            width: Browser.isDevice ? 16 : 14
        }, this.createElement);
        showSpinner(element);
    };
    TreeView.prototype.hideSpinner = function (element) {
        hideSpinner(element);
        element.innerHTML = '';
        removeClass([element], LOAD);
    };
    TreeView.prototype.setCheckedNodes = function (nodes) {
        nodes = JSON.parse(JSON.stringify(nodes));
        this.uncheckAll(this.checkedNodes);
        if (nodes.length > 0) {
            this.checkAll(nodes);
        }
    };
    /**
     * Called internally if any of the property value changed.
     * @param  {TreeView} newProp
     * @param  {TreeView} oldProp
     * @returns void
     * @private
     */
    TreeView.prototype.onPropertyChanged = function (newProp, oldProp) {
        for (var _i = 0, _a = Object.keys(newProp); _i < _a.length; _i++) {
            var prop = _a[_i];
            switch (prop) {
                case 'allowDragAndDrop':
                    this.setDragAndDrop(this.allowDragAndDrop);
                    break;
                case 'allowEditing':
                    this.wireEditingEvents(this.allowEditing);
                    break;
                case 'allowMultiSelection':
                    if (this.selectedNodes.length > 1) {
                        var sNode = this.getElement(this.selectedNodes[0]);
                        this.isLoaded = false;
                        this.removeSelectAll();
                        this.selectNode(sNode, null);
                        this.isLoaded = true;
                    }
                    this.setMultiSelect(this.allowMultiSelection);
                    this.addMultiSelect(this.allowMultiSelection);
                    break;
                case 'checkedNodes':
                    if (this.showCheckBox) {
                        this.checkedNodes = oldProp.checkedNodes;
                        this.setCheckedNodes(newProp.checkedNodes);
                    }
                    break;
                case 'autoCheck':
                    if (this.showCheckBox) {
                        this.autoCheck = newProp.autoCheck;
                        this.ensureIndeterminate();
                    }
                    break;
                case 'cssClass':
                    this.setCssClass(oldProp.cssClass, newProp.cssClass);
                    break;
                case 'enableRtl':
                    this.setEnableRtl();
                    break;
                case 'expandedNodes':
                    this.isAnimate = false;
                    this.setProperties({ expandedNodes: [] }, true);
                    this.collapseAll();
                    this.isInitalExpand = true;
                    this.setProperties({ expandedNodes: isNOU(newProp.expandedNodes) ? [] : newProp.expandedNodes }, true);
                    this.doExpandAction();
                    this.isInitalExpand = false;
                    this.isAnimate = true;
                    break;
                case 'expandOn':
                    this.wireExpandOnEvent(false);
                    this.setExpandOnType();
                    if (this.expandOnType !== 'None') {
                        this.wireExpandOnEvent(true);
                    }
                    break;
                case 'fields':
                    this.isAnimate = false;
                    this.initialRender = true;
                    this.updateListProp(this.fields);
                    this.reRenderNodes();
                    this.initialRender = false;
                    this.isAnimate = true;
                    break;
                case 'fullRowSelect':
                    this.setFullRow(this.fullRowSelect);
                    this.addFullRow(this.fullRowSelect);
                    break;
                case 'loadOnDemand':
                    if (this.loadOnDemand === false && !this.onLoaded) {
                        var nodes = this.element.querySelectorAll('li');
                        var i = 0;
                        while (i < nodes.length) {
                            this.renderChildNodes(nodes[i], true, null, true);
                            i++;
                        }
                        this.onLoaded = true;
                    }
                    break;
                case 'nodeTemplate':
                    this.nodeTemplateFn = this.templateComplier(this.nodeTemplate);
                    this.reRenderNodes();
                    break;
                case 'selectedNodes':
                    this.removeSelectAll();
                    this.setProperties({ selectedNodes: newProp.selectedNodes }, true);
                    this.doSelectionAction();
                    break;
                case 'showCheckBox':
                    this.reRenderNodes();
                    break;
                case 'sortOrder':
                    this.reRenderNodes();
                    break;
            }
        }
    };
    /**
     * Removes the component from the DOM and detaches all its related event handlers. It also removes the attributes and classes.
     */
    TreeView.prototype.destroy = function () {
        this.element.removeAttribute('aria-activedescendant');
        this.element.removeAttribute('tabindex');
        this.unWireEvents();
        this.wireEditingEvents(false);
        this.rippleFn();
        this.rippleIconFn();
        this.setCssClass(this.cssClass, null);
        this.setDragAndDrop(false);
        this.setFullRow(false);
        this.element.innerHTML = '';
        _super.prototype.destroy.call(this);
    };
    /**
     * Adds the collection of TreeView nodes based on target and index position. If target node is not specified,
     * then the nodes are added as children of the given parentID or in the root level of TreeView.
     * @param  { { [key: string]: Object }[] } nodes - Specifies the array of JSON data that has to be added.
     * @param  { string | Element } target - Specifies ID of TreeView node/TreeView node as target element.
     * @param  { number } index - Specifies the index to place the newly added nodes in the target element.
     * @param { boolean } preventTargetExpand - If set to true, the target parent node will be prevented from auto expanding.
     */
    TreeView.prototype.addNodes = function (nodes, target, index, preventTargetExpand) {
        if (isNOU(nodes)) {
            return;
        }
        nodes = JSON.parse(JSON.stringify(nodes));
        var dropLi = this.getElement(target);
        this.preventExpand = preventTargetExpand;
        if (this.fields.dataSource instanceof DataManager) {
            var dropUl_1;
            var icon = dropLi ? dropLi.querySelector('.' + ICON) : null;
            var proxy_5 = this;
            if (dropLi && icon && icon.classList.contains(EXPANDABLE) &&
                dropLi.querySelector('.' + PARENTITEM) === null) {
                proxy_5.renderChildNodes(dropLi, null, function () {
                    dropUl_1 = dropLi.querySelector('.' + PARENTITEM);
                    proxy_5.addGivenNodes(nodes, dropLi, index, true, dropUl_1);
                    proxy_5.triggerEvent();
                });
            }
            else {
                this.addGivenNodes(nodes, dropLi, index, true);
                this.triggerEvent();
            }
        }
        else if (this.dataType === 2) {
            this.addGivenNodes(nodes, dropLi, index);
        }
        else {
            if (dropLi) {
                this.addGivenNodes(nodes, dropLi, index);
            }
            else {
                nodes = this.getSortedData(nodes);
                for (var i = 0; i < nodes.length; i++) {
                    var pid = getValue(this.fields.parentID, nodes[i]);
                    dropLi = pid ? this.getElement(pid.toString()) : pid;
                    this.addGivenNodes([nodes[i]], dropLi, index);
                }
            }
            this.groupedData = this.getGroupedData(this.treeData, this.fields.parentID);
        }
        if (this.fields.dataSource instanceof DataManager === false) {
            this.preventExpand = false;
            this.triggerEvent();
        }
    };
    /**
     * Instead of clicking on the TreeView node for editing, we can enable it by using
     * `beginEdit` property. On passing the node ID or element through this property, the edit textBox
     * will be created for the particular node thus allowing us to edit it.
     * @param  {string | Element} node - Specifies ID of TreeView node/TreeView node.
     */
    TreeView.prototype.beginEdit = function (node) {
        var ele = this.getElement(node);
        if (!isNOU(ele)) {
            this.createTextbox(ele, null);
        }
    };
    /**
     * Checks all the unchecked nodes. You can also check specific nodes by passing array of unchecked nodes
     * as argument to this method.
     * @param  {string[] | Element[]} nodes - Specifies the array of TreeView nodes ID/array of TreeView node.
     */
    TreeView.prototype.checkAll = function (nodes) {
        if (this.showCheckBox) {
            this.doCheckBoxAction(nodes, true);
        }
    };
    /**
     * Collapses all the expanded TreeView nodes. You can collapse specific nodes by passing array of nodes as argument to this method.
     * You can also collapse all the nodes excluding the hidden nodes by setting **excludeHiddenNodes** to true. If you want to collapse
     * a specific level of nodes, set **level** as argument to collapseAll method.
     * @param  {string[] | Element[]} nodes - Specifies the array of TreeView nodes ID/ array of TreeView node.
     * @param  {number} level - TreeView nodes will collapse up to the given level.
     * @param  {boolean} excludeHiddenNodes - Whether or not to exclude hidden nodes of TreeView when collapsing all nodes.
     */
    TreeView.prototype.collapseAll = function (nodes, level, excludeHiddenNodes) {
        if (!isNOU(nodes)) {
            this.doGivenAction(nodes, COLLAPSIBLE, false);
        }
        else {
            if (level > 0) {
                this.collapseByLevel(select('.' + PARENTITEM, this.element), level, excludeHiddenNodes);
            }
            else {
                this.collapseAllNodes(excludeHiddenNodes);
            }
        }
    };
    /**
     * Disables the collection of nodes by passing the ID of nodes or node elements in the array.
     * @param  {string[] | Element[]} nodes - Specifies the array of TreeView nodes ID/array of TreeView nodes.
     */
    TreeView.prototype.disableNodes = function (nodes) {
        if (!isNOU(nodes)) {
            this.doDisableAction(nodes);
        }
    };
    /**
     * Enables the collection of disabled nodes by passing the ID of nodes or node elements in the array.
     * @param  {string[] | Element[]} nodes - Specifies the array of TreeView nodes ID/array of TreeView nodes.
     */
    TreeView.prototype.enableNodes = function (nodes) {
        if (!isNOU(nodes)) {
            this.doEnableAction(nodes);
        }
    };
    /**
     * Ensures visibility of the TreeView node by using node ID or node element.
     * When many TreeView nodes are present and we need to find a particular node, `ensureVisible` property
     * helps bring the node to visibility by expanding the TreeView and scrolling to the specific node.
     * @param  {string | Element} node - Specifies ID of TreeView node/TreeView nodes.
     */
    TreeView.prototype.ensureVisible = function (node) {
        var liEle = this.getElement(node);
        if (isNOU(liEle)) {
            return;
        }
        var parents = this.parents(liEle, '.' + LISTITEM);
        this.expandAll(parents);
        setTimeout(function () { liEle.scrollIntoView(true); }, 450);
    };
    /**
     * Expands all the collapsed TreeView nodes. You can expand the specific nodes by passing the array of collapsed nodes
     * as argument to this method. You can also expand all the collapsed nodes by excluding the hidden nodes by setting
     * **excludeHiddenNodes** to true to this method. To expand a specific level of nodes, set **level** as argument to expandAll method.
     * @param  {string[] | Element[]} nodes - Specifies the array of TreeView nodes ID/array of TreeView nodes.
     * @param  {number} level - TreeView nodes will expand up to the given level.
     * @param  {boolean} excludeHiddenNodes - Whether or not to exclude hidden nodes when expanding all nodes.
     */
    TreeView.prototype.expandAll = function (nodes, level, excludeHiddenNodes) {
        if (!isNOU(nodes)) {
            this.doGivenAction(nodes, EXPANDABLE, true);
        }
        else {
            if (level > 0) {
                this.expandByLevel(select('.' + PARENTITEM, this.element), level, excludeHiddenNodes);
            }
            else {
                this.expandAllNodes(excludeHiddenNodes);
            }
        }
    };
    /**
     * Gets all the checked nodes including child, whether it is loaded or not.
     */
    TreeView.prototype.getAllCheckedNodes = function () {
        var checkNodes = this.checkedNodes;
        var newCheck = [];
        var i = 0;
        var id = this.fields.id;
        for (i; i < this.treeData.length; i++) {
            //Checks if isChecked is enabled while node is not loaded in DOM
            var checked = null;
            var childNode = null;
            var isLoaded = this.element.querySelector('[data-uid="' + this.treeData[i][id].toString() + '"]');
            if (isLoaded && isLoaded.querySelector('.e-list-item') === null) {
                //Checks if isChecked is enabled for parent
                if (this.treeData[i][this.fields.isChecked] === true
                    && this.checkedElement.indexOf(this.treeData[i][id].toString()) === -1) {
                    newCheck.push(this.treeData[i][id].toString());
                    checked = 2;
                }
                //Checks for child nodes with isChecked enabled
                if (checked !== 2) {
                    checked = 1;
                }
                childNode = this.getChildNodes(this.treeData, this.treeData[i][id].toString());
                (childNode !== null) ? this.allCheckNode(childNode, newCheck, checked) : childNode = null;
            }
        }
        i = 0;
        //Gets checked nodes based on UI interaction
        while (i < checkNodes.length) {
            if (newCheck.indexOf(checkNodes[i]) !== -1) {
                i++;
                continue;
            }
            newCheck.push(checkNodes[i]);
            //Gets all child which is not loaded while parent is checked
            var parentNode = this.element.querySelector('[data-uid="' + checkNodes[i] + '"]');
            if (parentNode && parentNode.querySelector('.e-list-item') === null) {
                var child = this.getChildNodes(this.treeData, checkNodes[i].toString());
                (child && this.autoCheck) ? this.allCheckNode(child, newCheck) : child = null;
            }
            i++;
        }
        return newCheck;
    };
    /**
     * Get the node's data such as id, text, parentID, selected, isChecked, and expanded by passing the node element or it's ID.
     * @param  {string | Element} node - Specifies ID of TreeView node/TreeView node.
     */
    TreeView.prototype.getNode = function (node) {
        var ele = this.getElement(node);
        return this.getNodeData(ele, true);
    };
    /**
     * To get the updated data source of TreeView after performing some operation like drag and drop, node editing,
     * node selecting/unSelecting, node expanding/collapsing, node checking/unChecking, adding and removing node.
     * * If you pass the ID of TreeView node as arguments for this method then it will return the updated data source
     * of the corresponding node otherwise it will return the entire updated data source of TreeView.
     * * The updated data source also contains custom attributes if you specified in data source.
     * @param  {string | Element} node - Specifies ID of TreeView node/TreeView node.
     */
    TreeView.prototype.getTreeData = function (node) {
        var id = this.getId(node);
        this.updatePersistProp();
        if (isNOU(id)) {
            return this.treeData;
        }
        else {
            var data = this.getNodeObject(id);
            return isNOU(data) ? [] : [data];
        }
    };
    /**
     * Moves the collection of nodes within the same TreeView based on target or its index position.
     * @param  {string[] | Element[]} sourceNodes - Specifies the array of TreeView nodes ID/array of TreeView node.
     * @param  {string | Element} target - Specifies ID of TreeView node/TreeView node as target element.
     * @param  {number} index - Specifies the index to place the moved nodes in the target element.
     * @param { boolean } preventTargetExpand - If set to true, the target parent node will be prevented from auto expanding.
     */
    TreeView.prototype.moveNodes = function (sourceNodes, target, index, preventTargetExpand) {
        var dropLi = this.getElement(target);
        if (isNOU(dropLi)) {
            return;
        }
        for (var i = 0; i < sourceNodes.length; i++) {
            var dragLi = this.getElement(sourceNodes[i]);
            if (isNOU(dragLi) || dropLi.isSameNode(dragLi) || this.isDescendant(dragLi, dropLi)) {
                continue;
            }
            this.preventExpand = preventTargetExpand;
            this.dropAsChildNode(dragLi, dropLi, this, index);
        }
        if (this.fields.dataSource instanceof DataManager === false) {
            this.preventExpand = false;
        }
        this.triggerEvent();
    };
    /**
     * Removes the collection of TreeView nodes by passing the array of node details as argument to this method.
     * @param  {string[] | Element[]} nodes - Specifies the array of TreeView nodes ID/array of TreeView node.
     */
    TreeView.prototype.removeNodes = function (nodes) {
        if (!isNOU(nodes)) {
            for (var i = 0, len = nodes.length; i < len; i++) {
                var liEle = this.getElement(nodes[i]);
                if (isNOU(liEle)) {
                    continue;
                }
                this.removeNode(liEle);
            }
            if (this.dataType === 1) {
                this.groupedData = this.getGroupedData(this.treeData, this.fields.parentID);
            }
            this.triggerEvent();
        }
    };
    /**
     * Replaces the text of the TreeView node with the given text.
     * @param  {string | Element} target - Specifies ID of TreeView node/TreeView node as target element.
     * @param  {string} newText - Specifies the new text of TreeView node.
     */
    TreeView.prototype.updateNode = function (target, newText) {
        if (isNOU(target) || isNOU(newText) || !this.allowEditing) {
            return;
        }
        var liEle = this.getElement(target);
        if (isNOU(liEle)) {
            return;
        }
        var txtEle = select('.' + LISTTEXT, liEle);
        this.updateOldText(liEle);
        var eventArgs = this.getEditEvent(liEle, null, null);
        this.trigger('nodeEditing', eventArgs);
        if (eventArgs.cancel) {
            return;
        }
        this.appendNewText(liEle, txtEle, newText, false);
    };
    /**
     * Unchecks all the checked nodes. You can also uncheck the specific nodes by passing array of checked nodes
     * as argument to this method.
     * @param  {string[] | Element[]} nodes - Specifies the array of TreeView nodes ID/array of TreeView node.
     */
    TreeView.prototype.uncheckAll = function (nodes) {
        if (this.showCheckBox) {
            this.doCheckBoxAction(nodes, false);
        }
    };
    var TreeView_1;
    __decorate([
        Property(false)
    ], TreeView.prototype, "allowDragAndDrop", void 0);
    __decorate([
        Property(false)
    ], TreeView.prototype, "allowEditing", void 0);
    __decorate([
        Property(false)
    ], TreeView.prototype, "allowMultiSelection", void 0);
    __decorate([
        Complex({}, NodeAnimationSettings)
    ], TreeView.prototype, "animation", void 0);
    __decorate([
        Property()
    ], TreeView.prototype, "checkedNodes", void 0);
    __decorate([
        Property('')
    ], TreeView.prototype, "cssClass", void 0);
    __decorate([
        Property(false)
    ], TreeView.prototype, "enablePersistence", void 0);
    __decorate([
        Property(false)
    ], TreeView.prototype, "enableRtl", void 0);
    __decorate([
        Property()
    ], TreeView.prototype, "expandedNodes", void 0);
    __decorate([
        Property('Auto')
    ], TreeView.prototype, "expandOn", void 0);
    __decorate([
        Complex({}, FieldsSettings)
    ], TreeView.prototype, "fields", void 0);
    __decorate([
        Property(true)
    ], TreeView.prototype, "fullRowSelect", void 0);
    __decorate([
        Property(true)
    ], TreeView.prototype, "loadOnDemand", void 0);
    __decorate([
        Property()
    ], TreeView.prototype, "nodeTemplate", void 0);
    __decorate([
        Property()
    ], TreeView.prototype, "selectedNodes", void 0);
    __decorate([
        Property('None')
    ], TreeView.prototype, "sortOrder", void 0);
    __decorate([
        Property(false)
    ], TreeView.prototype, "showCheckBox", void 0);
    __decorate([
        Property(true)
    ], TreeView.prototype, "autoCheck", void 0);
    __decorate([
        Event()
    ], TreeView.prototype, "created", void 0);
    __decorate([
        Event()
    ], TreeView.prototype, "dataBound", void 0);
    __decorate([
        Event()
    ], TreeView.prototype, "dataSourceChanged", void 0);
    __decorate([
        Event()
    ], TreeView.prototype, "drawNode", void 0);
    __decorate([
        Event()
    ], TreeView.prototype, "destroyed", void 0);
    __decorate([
        Event()
    ], TreeView.prototype, "keyPress", void 0);
    __decorate([
        Event()
    ], TreeView.prototype, "nodeChecked", void 0);
    __decorate([
        Event()
    ], TreeView.prototype, "nodeChecking", void 0);
    __decorate([
        Event()
    ], TreeView.prototype, "nodeClicked", void 0);
    __decorate([
        Event()
    ], TreeView.prototype, "nodeCollapsed", void 0);
    __decorate([
        Event()
    ], TreeView.prototype, "nodeCollapsing", void 0);
    __decorate([
        Event()
    ], TreeView.prototype, "nodeDragging", void 0);
    __decorate([
        Event()
    ], TreeView.prototype, "nodeDragStart", void 0);
    __decorate([
        Event()
    ], TreeView.prototype, "nodeDragStop", void 0);
    __decorate([
        Event()
    ], TreeView.prototype, "nodeDropped", void 0);
    __decorate([
        Event()
    ], TreeView.prototype, "nodeEdited", void 0);
    __decorate([
        Event()
    ], TreeView.prototype, "nodeEditing", void 0);
    __decorate([
        Event()
    ], TreeView.prototype, "nodeExpanded", void 0);
    __decorate([
        Event()
    ], TreeView.prototype, "nodeExpanding", void 0);
    __decorate([
        Event()
    ], TreeView.prototype, "nodeSelected", void 0);
    __decorate([
        Event()
    ], TreeView.prototype, "nodeSelecting", void 0);
    TreeView = TreeView_1 = __decorate([
        NotifyPropertyChanges
    ], TreeView);
    return TreeView;
}(Component));
export { TreeView };
