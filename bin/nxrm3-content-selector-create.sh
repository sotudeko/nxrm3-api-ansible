#!/bin/bash

playbook=nxrm3-content-selector-create

ansible-playbook -v ../playbooks/${playbook}.yml --extra-vars @data/content-selector.json



